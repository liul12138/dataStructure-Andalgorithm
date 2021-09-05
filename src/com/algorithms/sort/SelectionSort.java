package com.algorithms.sort;

import com.algorithms.util.StopWatch;

/**
 * 选择排序
 */
public class SelectionSort{
    public static void main(String[] args) {

        Integer[] arr = {1,34,5,3,7,32,65,243,32,21,53};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        SelectionSort.sort(arr);
        stopWatch.stop();
        stopWatch.prettyPrint();
        Sort.show(arr);
    }
    public static void sort(Comparable[] a){
         for(int i = 0;i<a.length;i++){
             int min = i;
             for(int j = i;j<a.length;j++){
                 if(Sort.less(a[j],a[min])){
                     min = j;
                 }
             }
             Sort.exch(a,min,i);
         }
    }
}
