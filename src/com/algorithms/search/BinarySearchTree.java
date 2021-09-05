package com.algorithms.search;

public class BinarySearchTree<K extends Comparable<K>,V> {
    private Node root;
    private class Node{
        private K key;
        private V value;
        private Node left,right;
        private int N;

        public Node(K key,V value,int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
        private int size(Node n){
            if(n==null){
                return 0;
            }
            return n.N;
        }
        public int size(){
            return this.size(root);
        }
        public V get(K key){
          return this.get(root,key);
        }
        private V get(Node x,K key){
            if(x==null){
                return null;
            }
            else {
                //如果查找的key值比现在的key值要小的话，向左子树继续查找
                if(key.compareTo(x.key)<0){
                    get(x.left,key);
                }
                //查找右子树
                if(key.compareTo(x.key)>0){
                    get(x.right,key);

                }
                return x.value;
            }
        }

        public void put(){

        }
        private Node put(Node x,K key,V value){
            if(x==null){
                return  new Node(key,value,1);
            }
            int cmp = key.compareTo(x.key);
            if(cmp>0){
                return x.left = put(x.left,key,value);
            }
            else if(cmp<0){
                return x.right = put(x.right,key,value);
            }
            else {
                x.value = value;
            }
             x.N = size(x.left)+ x.size(x.right)+1;
            return x;
        }
    }
}
