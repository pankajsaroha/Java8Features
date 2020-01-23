package org.java.trees;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryTree<T> {

    class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
        }
    }

    Node head;

    int capacity = 5;
    int size = 0;

    T nodes[];

    @SuppressWarnings("unchecked")
    BinaryTree(Class<T> c) {
        T[] arr = (T[]) Array.newInstance(c, capacity);
        this.nodes = arr;
    }

    public static void main(String args[]) {
        BinaryTree<Integer> bt = new BinaryTree<>(Integer.class);
        for(int i=0; i<5; i++) {
            bt.nodes[i] = i;
        }
        System.out.println(Arrays.toString(bt.nodes));
    }

    void setCapacity() {
        if(size == capacity) {
            capacity *= 2;
            Arrays.copyOf(nodes, capacity);
        }
    }

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1 ; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2 ; }
    private int getParentIndex( int childIndex ) { return (childIndex - 1) / 2 ;}

    private boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size ; }
    private boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
    private boolean hasParent(int childIndex) { return getParentIndex(childIndex) >= 0 ;}

    private T getLeftChild(int parentIndex) { return nodes[getLeftChildIndex(parentIndex)] ; }
    private T getRightChild(int parentIndex) { return nodes[getRightChildIndex(parentIndex)] ; }
    private T getParent(int childIndex) { return nodes[getParentIndex(childIndex)] ; }

    public void add(T data) {
        setCapacity();
        nodes[++size] = data;
    }
}