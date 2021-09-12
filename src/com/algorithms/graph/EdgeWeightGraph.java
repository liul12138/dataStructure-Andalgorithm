package com.algorithms.graph;

public class EdgeWeightGraph{
    private final int V;//顶点总数
    private int E;//边的总数
    private BagImp<Edge>[] adj;//图的邻接矩阵
    public EdgeWeightGraph(int v){
        this.V = v;
        E = 0;
        for(int i = 0;i<v;i++){
            adj[i] = new BagImp<Edge>();
        }
    }

    public int V() {
        return V;
    }


    public int E() {
        return E;
    }

    /**
     * 添加边到图中
     * @param edge
     */

    public void addEdge(Edge edge){
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    /**
     * todo 将接口进行重构，实现edge接口，并且做出两个实现，分别为无权图和有权图
     * @param v
     * @return
     */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }


}
