package com.algorithms.graph;

public interface Search {
    //在图的遍历寻径中涉及大量的标识问题，同一节点面临着经过两次的问题
    boolean marked(int c);
    //
    int count();
}
