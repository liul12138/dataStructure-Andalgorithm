package com.algorithms.graph;

import java.util.Iterator;

public class DepthFirstSearch implements Search,Paths{
    //创建一个数组标识每个数组是否被访问过
    boolean[] marked;
    private int count;

    /**
     *
     * @param G 遍历图
     * @param s 遍历起点
     */
    DepthFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    /**
     * 寻找从s到v的路径
     * @param v 终点
     * @return
     */
    @Override
    public boolean hasPathTo(int v) {
        return false;
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    @Override
                    public boolean hasNext() {
                        return false;
                    }

                    @Override
                    public Integer next() {
                        return null;
                    }
                };
            }
        };
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        for(Integer e: G.adj(v)){
            //若是未被标记则继续遍历，否则不做处理退出本层遍历
            if(!marked[e]){
                dfs(G,e);
            }
        }
    }




}
