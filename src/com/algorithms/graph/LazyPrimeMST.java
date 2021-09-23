package com.algorithms.graph;

import com.algorithms.dataStruct.MinPQImp;

import java.util.ArrayDeque;
import java.util.Queue;

public class LazyPrimeMST {
    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst;//最小生成树的边
    private MinPQImp<Edge> pq;
    public LazyPrimeMST(EdgeWeightGraph G){
        pq = new MinPQImp<Edge>(G.edges());
        marked = new boolean[G.V()];
        mst = new ArrayDeque<>();
        visit(G,0);
        while (!pq.isEmpty()){
            Edge edge = pq.delMin();
            int v = edge.either(),w = edge.other(v);
            if(marked[v]&&marked[w]) continue;
            mst.add(edge);
            //访问边的两侧发现最小的权边
            if(!marked[v]) visit(G,v);
            if(!marked[w]) visit(G,w);
        }
    }
    private void visit(EdgeWeightGraph G,int v){
        marked[v] = true;
        for(Edge edge:G.adj(v)){
            if(!marked[edge.other(v)]){
                pq.insert(edge);
            }
        }
    }
    public Iterable<Edge> edges(){
        return mst;
    }

}
