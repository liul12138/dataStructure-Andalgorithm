package com.algorithms.dataStruct;

/**
 * union-find算法
 */
public class UF {
    private int[] ids;//分量id
    private int count;
     UF(int N){
        count = N;
        ids = new int[N];
        for(int i = 0;i<N;i++){
            ids[i] = i;
        }

     }
     void union(int p,int q){
       int pId = find(p);
       int qId = find(q);
       if(pId==qId){
           return;
       }
       else {

       }
     }
     int find(int p){
         return ids[p];
    }
    boolean connect(int p,int q){
         return ids[p]==ids[q];
    }
}
