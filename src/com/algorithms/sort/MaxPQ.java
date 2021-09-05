package com.algorithms.sort;

public interface MaxPQ<K extends Comparable<K>> {
    void insert(K k);
    K max();
    K delMax();
    boolean isEmpty();
    int size();
}
