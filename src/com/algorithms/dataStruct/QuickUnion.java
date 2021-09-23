package com.algorithms.dataStruct;


import java.util.Arrays;

/**
 * Quick-Union算法
 */
public class QuickUnion {

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.quickUnion(1,3);
        quickUnion.quickUnion(2,5);
        quickUnion.quickUnion(3,6);
        quickUnion.quickUnion(6,7);
        quickUnion.quickUnion(2,7);
        System.out.println("1->5:"+quickUnion.connect(1,5));
        System.out.println("4->9:"+quickUnion.connect(4,9));
        Arrays.stream(quickUnion.ids).forEach(System.out::println);
    }

    private int[] ids;//分量id
    private int count;
    public QuickUnion(int N){
        count = N;
        ids = new int[N];
        for(int i = 0;i<N;i++){
            ids[i] = i;
        }

    }

    /**
     * p和q的根节点连接起来
     * @param p p节点
     * @param q q节点
     */
    public void quickUnion(int p,int q){

        int pRoot = find(p);
        int qRoot = find(q);
        if(this.connect(p,q)){
            return;
        }
        ids[pRoot] = qRoot;
        //只需要更改一个链接就能让集合相连
        count--;
    }

    /**
     * 展出p节点的根节点
     * @param p p节点
     * @return pRoot
     */
    public int find(int p){
        //知道查找节点连接为自身的节点为止，找到了根节点
        while (p!=ids[p]){
            p= ids[p];
        }
        return p;
    }
    public boolean connect(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }
}
