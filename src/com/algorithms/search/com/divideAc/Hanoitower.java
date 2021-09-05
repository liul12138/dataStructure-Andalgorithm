package com.algorithms.search.com.divideAc;

public class Hanoitower {
    public static void main(String[] args) {
    hanoiTower(5,'A','B','C');
    }
    //不去考虑具体圆盘数量，只去考虑实现的整体思想
    //a->b a->c b->c
    public static void hanoiTower(int num,char a,char b,char c ){
        //下面一个盘，上面所有盘看作一个盘
        if(num==1){
            System.out.println("no."+num+" "+a+" move to "+c);
        }
     else {
            hanoiTower(num-1,a,c,b);
            System.out.println("no."+num+" "+a+" move to "+c);
            hanoiTower(num-1,b,a,c);

        }
    }
}
