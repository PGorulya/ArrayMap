package org.example;

import java.util.*;

public class ArrayMap<K, T> implements Map<K, T>, Iterable<T> {

    private final List<T> elements;
    private final Map<K, Integer> mapElements;

    int size = 0;

    public ArrayMap() {
        elements = new ArrayList<>();
        mapElements = new LinkedHashMap<>();
    }

    public ArrayMap(int initialCapacity) {
        elements = new ArrayList<>(initialCapacity);
        mapElements = new LinkedHashMap<>(initialCapacity);
    }

    @Override
    public T put(K key, T value) {
        T oldVal = null;
        if (containsKey(key)) {
            Integer index = mapElements.get(key);
            oldVal = elements.get(index);
            elements.set(index, value);
            mapElements.put(key,index);
        } else {
            mapElements.put(key, size++);
            elements.add(value);
        }
        return oldVal;
    }

    @Override
    public T get(Object key) {
        int ind = mapElements.getOrDefault(key, -1);
        return (ind == -1) ? null : elements.get(ind);
    }


    public T get(Integer index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else return elements.get(index);
    }


    public Integer getIndex(K key) {
        return mapElements.getOrDefault(key, -1);
    }

    @Override
    public T remove(Object key) {
        Integer index = mapElements.remove(key);
        if (index == null) {
            return null;
        } else {
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

    @Override
    public void putAll(Map<? extends K, ? extends T> m) {
        for (Entry<? extends K, ? extends T> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return mapElements.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return elements.contains(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elements.clear();
        mapElements.clear();
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        return Collections.unmodifiableSet(mapElements.keySet());
    }

    @Override
    public Collection<T> values() {
        return Collections.unmodifiableCollection(elements);
    }

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