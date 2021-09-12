package com.algorithms.dataStruct;

/**
 * 优先队列
 * 重要的操作是：删除最大元素和插入元素
 */
public interface PQ<K extends Comparable<K>> extends Collection {
    void insert(K key);
//    K max();
//    K delMax();
}
