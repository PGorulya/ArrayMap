package org.example;

public interface ListMap<T,K> {

    void add (T el, K mpKey);

    T get(Integer indexId);

    T get(K mpKey);

    void put(Integer indexId, T el);

    Integer indexKey(K mpKey);

}
