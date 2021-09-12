package com.algorithms.dataStruct;

public class MaxPQTest {
    public static void main(String[] args) {
        MinPQImp<Integer> maxPQImp = new MinPQImp<Integer>(8);
        maxPQImp.insert(20);
        maxPQImp.insert(4);
        maxPQImp.insert(215);
        maxPQImp.insert(2);
        maxPQImp.insert(2213);
        maxPQImp.insert(29);
        maxPQImp.insert(10);
        maxPQImp.insert(66);
        System.out.println(maxPQImp.delMin());
    }
}
