package com.algorithms.graph;

import java.util.Iterator;

public class BagImp<T> implements Iterable<T>, Bag<T> {
    //首指针
    private Node first;
    private int count;
    /**
     * 添加元素在节点到bag中
     * @param e 添加元素
     */
    @Override
    public void add(T e){

        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.element = e;
        count++;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    BagImp(){
        count=0;
    }


    //创建内部类，表示节点
    private class Node{
        T element;
        Node next;
    }
    private class ListIterator implements Iterator<T>{

        private Node cur = first;
        @Override
        public boolean hasNext() {
            //返回的是当前元素是否为空
            return cur==null;
        }

        @Override
        public T next() {
            //迭代指针到下一项并且返回当前项元素
           T e = cur.element;
           cur = cur.next;
           return e;
        }
    }

}
