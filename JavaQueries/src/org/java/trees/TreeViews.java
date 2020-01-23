package com.java.trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeViews {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    /* hd - horizontal distance */
    void topView(Node root) {

        if(root == null) return;

        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        LinkedList<QueueObj> queue = new LinkedList<>();
        queue.add(new QueueObj(root, 0));
        
        Map<Integer, Node> view = new TreeMap<>();

        while(!queue.isEmpty()) {

            QueueObj temp = queue.poll();

            if(!view.containsKey(temp.hd)) {
                view.put(temp.hd, temp.node);
            }

            if(temp.node.left != null) {
                queue.add(new QueueObj(temp.node.left, temp.hd - 1));
            }

            if(temp.node.right != null) {
                queue.add(new QueueObj(temp.node.right, temp.hd + 1));
            }
        }

        System.out.print("Top View : ");
        for(Entry<Integer, Node> entry : view.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    void bottomView(Node root) {
        if(root == null) return;

        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        LinkedList<QueueObj> queue = new LinkedList<>();
        queue.add(new QueueObj(root, 0));
        Map<Integer, Node> bottomViewMap = new TreeMap<>();

        while(!queue.isEmpty()) {
            QueueObj temp = queue.poll();

            bottomViewMap.put(temp.hd, temp.node);

            if(temp.node.left != null) {
                queue.add(new QueueObj(temp.node.left, temp.hd-1));
            }

            if(temp.node.right != null) {
                queue.add(new QueueObj(temp.node.right, temp.hd+1));
            }
        }
        System.out.print("\nBottom View : ");
        for(Entry<Integer, Node> entry : bottomViewMap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    void leftViewIterative(Node root) {
        if(root == null) return;
        int maxLevel = 0;

        class NodeLevel {
            Node node;
            int level;
            NodeLevel(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        LinkedList<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root, 1));
        System.out.print("\nLeft View Iterative : ");
        while(!queue.isEmpty()) {
            NodeLevel temp = queue.poll();
            if(maxLevel < temp.level) {
                System.out.print(temp.node.data + " ");
                maxLevel = temp.level;
            }

            if(temp.node.left != null) {
                queue.add(new NodeLevel(temp.node.left, temp.level+1));
            }

            if(temp.node.right != null) {
                queue.add(new NodeLevel(temp.node.right, temp.level+1));
            }
        }
    }

    void leftView(Node root) {
        System.out.print("\nLeft View : ");
        leftViewUtil(root, 1);
    }

    int maxLevel = 0;
    void leftViewUtil(Node node, int level) {
        if(node == null) return;

        if(maxLevel < level) {
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        leftViewUtil(node.left, level+1);
        leftViewUtil(node.right, level+1);
    }

    void running() {
        TreeViews tree = new TreeViews();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);

        tree.topView(tree.root);
        tree.bottomView(tree.root);
        tree.leftView(tree.root);
        tree.leftViewIterative(tree.root);

        TreeViews tree2 = new TreeViews();
        tree2.root = new Node(20);
        tree2.root.left = new Node(8); 
        tree2.root.right = new Node(22); 
        tree2.root.left.left = new Node(5); 
        tree2.root.left.right = new Node(3); 
        //tree2.root.right.left = new Node(4); 
        tree2.root.right.right = new Node(25); 
        tree2.root.left.right.left = new Node(10); 
        tree2.root.left.right.right = new Node(14);

        System.out.println();
        tree2.topView(tree2.root);
        tree2.bottomView(tree2.root);
        tree2.leftView(tree2.root);
        tree2.leftViewIterative(tree2.root);
    }

    public static void main(String[] args) {
        TreeViews tree = new TreeViews();

        tree.running();
    }
}