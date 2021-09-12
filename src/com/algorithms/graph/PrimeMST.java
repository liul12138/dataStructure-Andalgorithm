package com.algorithms.graph;

/**
 * prime最小生成树，
 * N个顶点，找出N-1条边生成Minimum Cost Spanning Tree
 * prime 算法和 迪捷斯卡算法其实本质上只是有向和无项图的操作区别
 * 利用切分定理，
 *
 */
public class PrimeMST {
    private Edge[] edgeTo;//距离树最近的边
    private double distTo[];//
    private boolean[] marked;//如果v在树中则为true
    public PrimeMST(EdgeWeightGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for(int i = 0;i<G.V();i++){
            distTo[i] = Double.POSITIVE_INFINITY;

        }
    }
}
