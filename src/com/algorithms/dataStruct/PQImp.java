package com.algorithms.dataStruct;

import com.algorithms.sort.Sort;

public class PQImp<K extends Comparable<K>> implements PQ<K> {

    private K[] pq; //基于堆的完全二叉树
    private int N = 0;//存储数据于1~N中，pq[0]不做使用

    public PQImp(int maxN){
            pq =  (K[])new Comparable[maxN+1];

    }

    /**
     * 如果堆中有某个节点变得比自己的父节点还要大，则需要与自己的父节点不断做比较直至找到合适的位置，
     * 其父节点的位置在2/k处
     * 上浮操作
     * @param k 节点的位置
     */
    private void swim(int k){
        while(k>1&& Sort.less(pq[k/2],pq[k])){
            Sort.exch(pq,k/2,k);
            k = 2/k;
        }

    }

    /**
     * 下沉操作，当一个数要比起其子节点要小则应下沉至合适位置，
     *与子节点中较大的元素进行exch可保证其修复状态
     * @param k 正在操作的元素index
     */
    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            //若j+1位置上的数据比j上的要小的话，则交换j+1与父节点，始终交换较大者与父节点
            if(j<N&&Sort.less(pq[j],pq[j+1])){j++;};
            //若是父节点不再比子节点中的一个要小的话则跳出循环
            if(!Sort.less(pq[k],pq[j])){break;};

            Sort.exch(pq,j,k);
        }

    }
    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void insert(K key) {
        N++;
    pq[N] = key;
    //确保N能到达正确的位置
    swim(N);
    }


    public K max() {
        return pq[1];
    }


    public K delMax() {
        K max = pq[1];
        Sort.exch(pq,1,N--);
        pq[N+1] = null;
        //运用sink数组下沉
        sink(1);
        return pq[1];
    }
}
