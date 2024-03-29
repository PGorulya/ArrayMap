package org.example;

import java.util.*;
import java.util.function.Consumer;

/**
 * ArrayMap is a map implementation that stores key-value pairs as a list of elements,
 * and maintains a separate map that maps each key to the corresponding index in the list.
 * This allows for O(1) access of elements.
 * This class implements the Map interface, and also provides an iterator over the values
 * in the map.
 *
 * @param <K> the type of keys in the map
 * @param <T> the type of values in the map
 */
public class ArrayMap<K, T> implements Map<K, T>, Iterable<T> {

    // The list to store the elements in the map
    private final List<T> elements;

    // The map to store the mapping between keys and the corresponding index in the list
    private final Map<K, Integer> mapElements;

    //The size field is used to keep track of the number of elements in the map.
    int size = 0;

    /**
     * Constructs an empty ArrayMap with default initial capacity.
     */
    public ArrayMap() {
        elements = new ArrayList<>();
        mapElements = new LinkedHashMap<>();
    }

    /**
     * Constructs an empty ArrayMap with the specified initial capacity.
     * @param initialCapacity the initial capacity of the ArrayMap.
     */
    public ArrayMap(int initialCapacity) {
        elements = new ArrayList<>(initialCapacity);
        mapElements = new LinkedHashMap<>(initialCapacity);
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced by the specified value.
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public T put(K key, T value) {
        T oldVal = null;
        if (containsKey(key)) {
            // If the key already exists in the map, update the value at the corresponding index in the list
            Integer index = mapElements.get(key);
            oldVal = elements.get(index);
            elements.set(index, value);
            mapElements.put(key,index);
        } else {
            // If the key does not exist in the map, add the value to the end of the list and update the mapping
            mapElements.put(key, size++);
            elements.add(value);
        }
        return oldVal;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    @Override
    public T get(Object key) {
        // Get the index of the key in the list from the map
        int ind = mapElements.getOrDefault(key, -1);
        // If the index is -1, the key does not exist in the map, so return null; otherwise, return the value at the index
        return (ind == -1) ? null : elements.get(ind);
    }


    /**
     * Returns the value at the specified index in the list.
     * @param index the index of the value to return
     * @return the value at the specified index in the list.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public T get(Integer index) {
        // If the index is out of bounds, throw an exception; otherwise, return the value at the index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else return elements.get(index);
    }

    // Returns the index of the specified key in the map
    public Integer getIndex(K key) {
        return mapElements.getOrDefault(key, -1);
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key the key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key
     */
    @Override
    public T remove(Object key) {
        Integer index = mapElements.remove(key);
        if (index == null) {
            return null;
        } else {
            // Remove the element at the specified index from the list and update the mapping to reflect the new indices
            T oldValue = elements.remove(index.intValue());
            // update mapElements to reflect the new indices of the elements
            List<K> list = new ArrayList<>(mapElements.keySet());
            size--;
            for (int i = index; i < size; i++) {
                mapElements.put(list.get(i), i);
            }
            return oldValue;
        }
    }

    /**
     * Inserts all key-value pairs from the given map into this map.
     *
     * @param m the map whose key-value pairs are to be inserted into this map
     */
    @Override
    public void putAll(Map<? extends K, ? extends T> m) {
        for (Entry<? extends K, ? extends T> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }


    /**
     * Returns true if the map contains the given key, false otherwise.
     *
     * @param key the key to be checked for presence in the map
     * @return true if the map contains the given key, false otherwise
     */
    @Override
    public boolean containsKey(Object key) {
        return mapElements.containsKey(key);
    }

    /**
     * Returns true if the map contains the given value, false otherwise.
     *
     * @param value the value to be checked for presence in the map
     * @return true if the map contains the given value, false otherwise
     */
    @Override
    public boolean containsValue(Object value) {
        return elements.contains(value);
    }

    /**
     * Returns the number of elements in the map.
     *
     * @return the number of elements in the map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the map is empty, false otherwise.
     *
     * @return true if the map is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * removes all key-value pairs from the map.
     */
    @Override
    public void clear() {
        elements.clear();
        mapElements.clear();
        size = 0;
    }

    /**
     * returns an unmodifiable set of the keys in the map.
     *
     * @return an unmodifiable set of the keys in the map.
     */
    @Override
    public Set<K> keySet() {
        return Collections.unmodifiableSet(mapElements.keySet());
    }

    // returns an unmodifiable collection of the values in the map.
    @Override
    public Collection<T> values() {
        return Collections.unmodifiableCollection(elements);
    }

    //returns an unmodifiable set of the key-value pairs in the map.
    @Override
    public Set<Entry<K, T>> entrySet() {
        Set<Entry<K, T>> entrySet = new HashSet<>();
        for (Entry<K, Integer> entry : mapElements.entrySet()) {
            T value = elements.get(entry.getValue());
            entrySet.add(new AbstractMap.SimpleEntry<>(entry.getKey(), value));
        }
        return entrySet;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int pointer = 0;
            @Override
            public boolean hasNext() {
                return pointer < size;
            }
            @Override
            public T next() {
                return elements.get(pointer++);
            }
            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                Iterator.super.forEachRemaining(action);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ArrayMap\n[elements:\n");
        for (T element : elements) {
            sb.append(element).append(", \n");
        }
        sb.append("]\n[mapElements:\n");
        mapElements.forEach((k, v) -> sb.append("Key= " + k + ", Index= " + v + "\n"));
        sb.append("]");
        return sb.toString();
    }
}