package com.algorithms.graph;

public interface Graph {
    //顶点数
    int V();
    //边数
    int E();
    //添加顶点
    void addEdge(int v,int w);
    //返回一个可迭代的v的所有顶点
    Iterable<Integer> adj(int v);
}
