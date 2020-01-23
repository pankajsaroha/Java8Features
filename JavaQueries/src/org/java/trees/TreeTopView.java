package com.java.trees;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeTopView {

    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    class NodeLevel {
        Node node;
        int level;
        NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    void topView(Node root) {
        Map<Integer, NodeLevel> map = new TreeMap<>();
        fillMap(root, 0, 0, map);
        for(Entry<Integer, NodeLevel> entry : map.entrySet()) {
            System.out.print(entry.getValue().node.data + " ");
        }
    }

    void fillMap(Node root, int d, int l, Map<Integer, NodeLevel> map) {
        if(root == null)
            return;

        if(!map.containsKey(d)) {
            map.put(d, new NodeLevel(root, l));
        } else {
            int currentNodeLevel = map.get(d).level;
            if(currentNodeLevel > l) {
                map.put(d, new NodeLevel(root, l));
            }
        }

        fillMap(root.left, d-1, l+1, map);
        fillMap(root.right, d+1, l+1, map);
    }

    void running() {
        TreeTopView tree = new TreeTopView();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.right = new Node(4); 
        tree.root.left.right.right = new Node(5); 
        tree.root.left.right.right.right = new Node(6); 
        System.out.println("Following are nodes in top view of Binary Tree");  
        tree.topView(tree.root);
    }
    
    public static void main(String[] args) {
        TreeTopView t = new TreeTopView();
        t.running();
    }
}