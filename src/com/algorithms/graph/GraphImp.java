package com.algorithms.graph;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 无向图的实现
 */
public class GraphImp implements Graph{
    //顶点数
    private final int V;
    //边的条数
    private int E;
    //创建临界链表
    private Bag<Integer>[] adj;
     GraphImp(int V){
        this.V = V;
        this.E = 0;
        //初始化所有bag链表
         for(int i = 0;i<V;i++){
             adj[i] = new BagImp<Integer>();
         }
    }

    @Override
    public int V() {
        return this.V;
    }

    @Override
    public int E() {
        return this.E;
    }

    @Override
    public void addEdge(int v, int w) {
         adj[v].add(w);
         adj[w].add(v);
         E++;
    }

    public void addEdgeAll(Map<Integer,Integer> m){
      Set<Map.Entry<Integer, Integer>> set =  m.entrySet();
      for(Map.Entry<Integer,Integer> e:set){
          this.addEdge(e.getKey(),e.getValue());
      }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return null;
    }
}
