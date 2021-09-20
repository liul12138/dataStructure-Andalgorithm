package com.algorithms.dataStruct;


import java.util.Arrays;

/**W
 * 线段树是一种常用的数据结构
 */
public class SegmentTree {
    static int MAX_SIZE = 30;
    /**
     * 构建一颗线段树
     * @param tree 生产的线段树
     * @param arr 原来用于生成线段树的数组
     * @param start 分割的起始位置
     * @param end 分割的结束位置
     */
    public static void buildTree(int[] arr,int[] tree,int start,int end,int node){


        int left_node = 2*node+1;

        int right_node = 2*node+2;

        if(start==end){
            tree[node] = arr[start];
            return;
        }

        int mid = (start+end)/2;
        //生产左子树
        buildTree(arr,tree, start,mid,left_node);
        //生成右子树
        buildTree(arr,tree,mid+1,end,right_node);
        //递归到最低层时父节点等于两子节点之和
        tree[node] = tree[left_node]+tree[right_node];

    }

    /**
     * 更新树中的数字
     *
     * @param index
     * @param value
     */
    public static void updateTree(int[] arr, int[] tree,int index,int value){
        updateTree(arr,tree,0,arr.length-1,0,index,value);
    }

    /**
     *
     * @param arr 原有数组
     * @param tree 线段树
     * @param start 区间的起始位置
     * @param end 区间的结束位置
     * @param node 区间的节点
     * @param idx 需要更新的节点位置
     * @param value 更新后的节点值
     */
    private static void updateTree(int[] arr,int[] tree,int start,int end,int node,int idx,int value ){
        //中点
        int left_node = node*2+1;
        int right_node = node*2+2;
        int mid = (start+end)/2;
        if(start==end){
            //更新这个节点为最新值
            tree[node] = value;
            return;
        }
        if(idx>=mid&&idx<=end){
            //在右树执行查找
            updateTree(arr,tree,mid+1,end,right_node,idx,value);
        }
        else {
            //在左树继续执行查找
            updateTree(arr,tree,start,mid,left_node,idx,value);
        }
        //更新所有父节点的值
        tree[node] = tree[left_node]+tree[right_node];
    }

    /**
     *
     * @param arr 原数组
     * @param tree 生成线段树
     * @param start 求和起始位置
     * @param end 求和结束位置
     * @param node 当前求取的节点
     * @param start_pos 求和起始位置
     * @param end_pos 求和结束位置
     */
    public static int query_tree(int[] arr,int[] tree,int start,int end,int node,int start_pos,int end_pos){

        int mid = (start+end)/2;

        int left_node = node*2+1;

        int right_node = node*2+2;

        if(end_pos<start||start_pos>end){
            return 0;
        }
        if(start==end||(start_pos==start&&end_pos==end)){
            return tree[node];
        }

        return  query_tree(arr,tree,start,mid,left_node,start_pos,end_pos)+
                query_tree(arr,tree,mid+1,end,right_node,start_pos,end_pos)
                ;
    }

    public static void main(String[] args) {

        int[] arr = {1,3,5,7,9,12};
        int[] tree = new int[MAX_SIZE];
        buildTree(arr,tree,0,5,0);
        int val =  query_tree(arr,tree,0,arr.length-1,0,2,4);
        System.out.println(val);
    }
}
