package com.algorithms.sort;

public class Sort {

    public static void main(String[] args) {

    }
    /**
     *
     * @param a 传入的数组
     * @param i 交换元素i
     * @param j 交换元素j
     */
    public static void exch(Comparable[] a,int i,int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static void show(Comparable[] a){
        for (Comparable ele : a) {
            System.out.println(ele+"  ");
        }
        System.out.println("   ");
    }

}
