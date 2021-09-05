package com.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstPaths implements Search{
    private int count;
    private boolean[] marked;
    /**
     *
     * @param G 查找图
     * @param s 查找起点
     */
    BreadthFirstPaths(Graph G,int s){
        this.marked = new boolean[G.V()];
        this.bfs(G,s);

    }
    @Override
    public boolean marked(int c) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    //用队列来模拟广度遍历的过程
    void bfs(Graph G,int s){
        Queue<Integer> queue = new ArrayDeque<>();
        marked[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            int v = queue.remove();
            for(int t:G.adj(v)){
                if(!marked[t]){
                    marked[t] = true;
                    queue.add(t);
                }
            }
        }
    }
}
