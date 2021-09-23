package com.algorithms.sort;

public class InsertionSort {
    public static void main(String[] args) {
        Character[] arr = {'A','b','z','C'};
        InsertionSort.sort(arr);
        Sort.show(arr);
    }
    /**
     * 基本思路：循环插入
     * @param a 排序数组
     */
    //即分为排序部分和未排序部分麻将未排序部分的元素以此插入到已排序部分的适当位置
    public static void sort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            //发现插入的数比原来数值要小
            Comparable key = a[i];
            int j;
            for(j=i-1;j>=0&&Sort.less(a[j],key);j--){

                Sort.exch(a,j+1,j);
            }
            a[j+1] = key;
        }
    }
}
