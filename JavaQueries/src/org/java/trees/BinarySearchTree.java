package com.java.trees;

import java.util.ArrayDeque;


public class BinarySearchTree<T extends Comparable<T>> {

    class Node {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
        }
    }

    Node root;

    void insert(Node temp, T data) {
        if (temp == null) {
            temp = new Node(data);
            root = temp;
        } else {
            if (data.compareTo(temp.data) < 0) {
                if (temp.left == null) {
                    temp.left = new Node(data);
                    return;
                }
                insert(temp.left, data);
            } else {
                if (temp.right == null) {
                    temp.right = new Node(data);
                    return;
                }
                insert(temp.right, data);
            }
        }
    }

    public int countLeaves(Node temp) {
        if (temp == null) {
            return 0;
        }
        if (isLeaf(temp)) {
            System.out.print(temp.data + " ");
            return 1;
        } else {
            return countLeaves(temp.left) + countLeaves(temp.right);
        }
    }

    boolean isLeaf(Node temp) {
        return temp.left == null && temp.right == null;
    }

    void inOrder(Node temp) {
        if (temp != null) {
            inOrder(temp.left);
            System.out.print(temp.data + " ");
            inOrder(temp.right);
        }
    }

    void preOrder(Node temp) {
        if (temp != null) {
            System.out.print(temp.data + " ");
            preOrder(temp.left);
            preOrder(temp.right);
        }
    }

    void postOrder(Node temp) {
        if (temp != null) {
            postOrder(temp.left);
            postOrder(temp.right);
            System.out.print(temp.data + " ");
        }
    }

    void inOrderIterative() {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    void preOrderIterative() {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node temp = root;
        stack.push(temp);
        while (!stack.isEmpty()) {
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            temp = stack.pop();
        }
    }

    void postOrderIterative() {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        Node previous = null;
        while (!stack.isEmpty()) {
            Node current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    System.out.print(current.data + " ");
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    System.out.print(current.data + " ");
                }
            } else if (current.right == previous) {
                stack.pop();
                System.out.print(current.data + " ");
            }
            previous = current;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        //Integer[] arr = { 4, 3, 5, 7, 1, 9, 0 };
        String[] str = { "Pankaj", "Nupur", "Anmol", "Divya", "Saideep", "Sukanya", "Sneha" };
        for (String num : str) {
            bst.insert(bst.root, num);
        }
        System.out.print("InOrder - ");
        bst.inOrder(bst.root);
        System.out.print("\nInOrder Iterative - ");
        bst.inOrderIterative();
        System.out.print("\nPreOrder - ");
        bst.preOrder(bst.root);
        System.out.print("\nPreOrder Iterative - ");
        bst.preOrderIterative();
        System.out.print("\nPostOrder - ");
        bst.postOrder(bst.root);
        System.out.print("\nPostOrder Iterative - ");
        bst.postOrderIterative();
        System.out.println();
        System.out.println(bst.countLeaves(bst.root));
    }
}