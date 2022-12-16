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
    public void add(T el, K mpKey) {
        elements.add(el);
//        elements.lastIndexOf(el);
        mapElements.put(mpKey, index++);
     }

    @Override
    public T get(Integer indexId) {
        return elements.get(indexId);
    }

    @Override
    public T get(K mpKey) {
        return elements.get(mapElements.get(mpKey));
    }

    @Override
    public void put(Integer indexId, T el) {
        elements.add(indexId, el);
    }

    @Override
    public Integer indexKey(K mpKey) {
        return mapElements.get(mpKey);
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

//    @Override
//    public String toString() {
//        return "ArrayMap{" +
//                "elements=" + elements +
//                ", mapElements=" + mapElements +
//                '}';
//    }

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
