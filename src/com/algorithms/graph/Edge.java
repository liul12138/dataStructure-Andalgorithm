package com.algorithms.graph;

/**
 * 加权无向图的边
 */
public class Edge implements Comparable<Edge>{
    private final int v;//顶点之一
    private final int w;//另一个顶点
    private final double weight;//边的权重
    Edge(int v, int w,double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight(){
        return this.weight;
    }
    public int either(){
        return v;
    }
    public int other(int vertex){
        if(vertex==v) return w;
        if(vertex==w) return v;
        else throw new RuntimeException("inconsistent edge");
    }

    @Override
    public int compareTo(Edge o) {
        if(this.getWeight()>o.getWeight()) return 1;
        else if(this.getWeight()<o.getWeight()) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}