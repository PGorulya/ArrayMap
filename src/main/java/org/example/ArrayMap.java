package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<T,K> implements ListMap<T,K>, Iterable<T>{

    private List<T> elements;
    private HashMap<K, Integer> mapElements;

    Integer index = 0;

    public ArrayMap() {
        elements = new ArrayList<>();
        mapElements = new HashMap<>();
    }



    @Override
    public boolean add(T el, K key) {
        mapElements.put(key, index++);
        return elements.add(el);
     }

    @Override
    public T get(Integer indexId) {
        return elements.get(indexId);
    }

    @Override
    public void put(Integer indexId, T el, K key) {
        elements.add(indexId, el);
        mapElements.put(key, indexId);
    }

    @Override
    public boolean contains(K key) {
        return  mapElements.containsKey(key);
    }

    @Override
    public Integer findIndex(K key) {
        return mapElements.get(key);
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < index;
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
        for (int i = 0; i < index; i++) {
            sb.append(elements.get(i)).append(", \n");
        }
        sb.append("]\n[mapElements:\n");
        mapElements.forEach((k, v) -> sb.append("Key= " + k + ", Value= " + v + "\n"));
        sb.append("]");
        return sb.toString();
    }
}
