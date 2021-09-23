package com.algorithms.graph;

import com.algorithms.dataStruct.MinPQImp;
import com.algorithms.dataStruct.QuickUnion;
import com.algorithms.dataStruct.UF;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Kruskal算法主要思想是将边的权重按从小到大来处理它们，将边加入树中，加入的边不会与已加入的边形成环，
 * 直到树中含有V-1条边为止，由森林生成一颗树的过程，这个过程同样应用了切分定理
 */
public class KruskalMST {
    //创建一个队列来存储最小生成树的边
    private Queue<Edge> mst = new ArrayDeque<>();

    public KruskalMST(EdgeWeightGraph edgeWeightGraph) {
        //用一个优先级队列来存储这些边，每使用一个就删除一个，并且通过Quick-Union算法来出查看
        //是否处于同一颗子树中
        MinPQImp<Edge> edgeMinPQ = new MinPQImp<Edge>(edgeWeightGraph.edges());
        //查询是否节点是否连同
        QuickUnion uf = new QuickUnion(edgeWeightGraph.V());
        //当子树不为空时或者有V-1条边连同顶点时
        while (!edgeMinPQ.isEmpty() && mst.size() < edgeWeightGraph.V() - 1) {
            //得到最小的边
            Edge edge = edgeMinPQ.delMin();
            //节点v
            int v = edge.either();
            //另一个节点w
            int w = edge.other(v);
            if (uf.connect(v, w)) {
                continue;
            }
            uf.quickUnion(v, w);
            mst.add(edge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

}
