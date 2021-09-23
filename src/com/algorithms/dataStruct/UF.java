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
           //将p的分量重新命名为q的名称
        for(int i=0;i<ids.length;i++){
            if(ids[i]==pId){
                ids[i] = qId;
            }
        }
       }
     }
     int find(int p){
         return ids[p];
    }
    boolean connect(int p,int q){
         return ids[p]==ids[q];
    }
}
