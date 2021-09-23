package com.algorithms.graph;

public interface Bag<T> extends Iterable<T>{
    void add(T e);
    boolean isEmpty();
    int size();
}
