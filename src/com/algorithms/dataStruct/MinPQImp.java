package com.algorithms.dataStruct;

import com.algorithms.sort.Sort;

import java.util.Iterator;

public class MinPQImp<K extends Comparable<K>> implements PQ<K> {

    private K[] pq; //基于堆的完全二叉树
    private int N = 0;//存储数据于1~N中，pq[0]不做使用

    public MinPQImp(int maxN){
        pq =  (K[])new Comparable[maxN+1];

    }
    public MinPQImp(Iterable<K> items){
        Iterator<K> iter = items.iterator();
        int cnt = 0;
        while (iter.hasNext()){
            pq[cnt] = iter.next();
        }
    }

    private void swim(int k){
        while(k>1&& Sort.less(pq[k],pq[k/2])){
            Sort.exch(pq,k/2,k);
            k = 2/k;
        }

    }


    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            //若j+1位置上的数据比j上的要大的话，则交换j+1与父节点，始终交换较大者与父节点
            if(j<N&&Sort.less(pq[j+1],pq[j])){j++;};
            //若是父节点不再比子节点中的一个要小的话则跳出循环
            if(!Sort.less(pq[j],pq[k])){break;};

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


    public K min() {
        return pq[1];
    }


    public K delMin() {
        K max = pq[1];
        Sort.exch(pq,1,N--);
        pq[N+1] = null;
        //运用sink数组下沉
        sink(1);
        return pq[1];
    }
}
