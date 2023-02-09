package org.example;

import java.util.*;

public class ArrayMap<K, T> implements Iterable<T>{

    private final List<T> elements;
    private final Map<K, Integer> mapElements;

    int size = 0;

    public ArrayMap() {
        elements = new ArrayList<>();
        mapElements = new HashMap<>();
    }


    /**
     * Appends the specified element to the end of this list.
     *
     * @param el element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */

    public boolean add(K key, T el) {
        if (contains(key)) {
            //replace elements by index = map.get(key)
            elements.set(mapElements.get(key), el);
            return true;
        }
        else {
            mapElements.put(key, size++);
            return elements.add(el);
        }
    }

    public boolean put(K key, T el) {
        if (contains(key)) {
            //replace elements by index = map.get(key)
            elements.set(mapElements.get(key), el);
            return true;
        }
        else {
            mapElements.put(key, size++);
            return elements.add(el);
        }
    }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T get(Integer index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else return elements.get(index);
    }

    public T get(K key) {
        int ind = mapElements.get(key);
        return elements.get(ind);
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param el      element to be stored at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void set(Integer index, T el, K newKey, K oldKey) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            elements.set(index, el);
            mapElements.remove(oldKey);
            mapElements.put(newKey, index);
        }
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     */
    public boolean contains(K key) {
        return mapElements.containsKey(key);
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    public Integer findIndex(K key) {
        return mapElements.getOrDefault(key, -1);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Remove the specified element to the end of this list.
     *
     * @param el element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public boolean remove(K key, T el) {
        mapElements.remove(key);
        size--;
        return elements.remove(el);
    }

    public boolean remove(K key, Integer index) {
        mapElements.remove(key);
        size--;
        return elements.remove(index);
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clear of all elements
     */
    public void clear() {
        elements.clear();
        mapElements.clear();
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
        for (int i = 0; i < size; i++) {
            sb.append(elements.get(i)).append(", \n");
        }
        sb.append("]\n[mapElements:\n");
        mapElements.forEach((k, v) -> sb.append("Key= " + k + ", Index= " + v + "\n"));
        sb.append("]");
        return sb.toString();
    }
}
