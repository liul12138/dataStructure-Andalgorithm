package com.algorithms.sort;


public class MergeSort {
    public static void main(String[] args) {
        Integer[] arr = {1,343,32,4,3,23,535,53253,53,53,435,344,5376,8,54};
        MergeSort.sort(arr);
        Sort.show(arr);
    }
    //归并所需的辅助数组
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0, a.length-1);
    }

    /**
     * 归并排序体现了分治的思想，即将问题划分为小的问题解决最后合并的过程
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a,int lo,int hi){
        //15个数字
            if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
   public static void merge(Comparable[] a,int lo,int mid,int hi){
       //首先我们用一个辅助数组来复制原数组的内容
       int i = lo,j=mid+1;
       if(Sort.less(a[mid],a[mid+1])){return;}
       for(int k = lo;k<=hi;k++){
           aux[k] = a[k];
       }
       for(int k = lo;k<=hi;k++){
            //算法第四版pdf此处有错误
            //左侧用尽
           if(i>mid){a[k]=aux[j++];}
           //右侧用尽
           else if(j>hi){a[k]=aux[i++];}
           //如果右侧数组比左侧小，则将右侧指针往后移，右侧的数值同时归并到原数组中
           else if(Sort.less(aux[j],aux[i])){a[k]=aux[j++];}
           //反之左侧的数值归并到原数组当中去
           else a[k] = aux[i++];
       }
   }
}
