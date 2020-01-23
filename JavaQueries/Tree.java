import java.util.LinkedList;
import java.util.List;

public class Tree {

    static class Node {
        Integer data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node insert(Node root, Integer data) {
        Node node = new Node(data);
        if(root == null) {
            return node;
        } else {
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                Node temp = queue.poll();
                if(temp.left == null) {
                    temp.left = node;
                    return root;
                } else {
                    queue.add(temp.left);
                }
                if(temp.right == null) {
                    temp.right = node;
                    return root;
                } else {
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    void delete(Node root, Integer data) {
        if(root == null) {
            return;
        } else {
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            Node last = getLastNode(root);
            while(!queue.isEmpty()) {
                Node temp = queue.poll();
                if(temp.data == data) {
                    temp.data = last.data;
                    last.data  = null;
                    last = null;
                    if(temp.left == last) {
                        temp.left = null;
                    } else {
                        temp.right = null;
                    }
                    return;
                }
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    Node getLastNode(Node root) {
        Node last = null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            last = queue.poll();
            if(last.left != null) {
                queue.add(last.left);
            }
            if(last.right != null) {
                queue.add(last.right);
            }
        }
        return last;
    }

    void prePrint(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            prePrint(root.left);
            prePrint(root.right);
        }
    }

    void inPrint(Node root) {
        if(root != null) {
            inPrint(root.left);
            System.out.print(root.data+" ");
            inPrint(root.right);
        }
    }

    void postPrint(Node root) {
        if(root != null) {
            postPrint(root.left);
            postPrint(root.right);
            System.out.print(root.data+" ");
        }
    }

    void levelPrint(Node root) {
        if(root == null) {
            System.out.println("Tree is empty");
        } else {
            List<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                root = queue.remove(0);
                System.out.print(root.data+" ");
                if(root.left != null) {
                    queue.add(root.left);
                }
                if(root.right != null) {
                    queue.add(root.right);
                }
            }
        }
    }

    int getHeight(Node root) {
        if(root == null) {
            return -1;
        } else {
            int leftSubtreeDepth = getHeight(root.left);
            int rightSubtreeDepth = getHeight(root.right);

            if(leftSubtreeDepth > rightSubtreeDepth) {
                return leftSubtreeDepth+1;
            } else {
                return rightSubtreeDepth+1;
            }
        }
    }

    public static void main(String args[]) {
        Tree tree = new Tree();
        int arr[] = new int[] {10, 4, 7, 2, 9, 1, 3, 8, 5, 6, 0};
        Node root = null;
        for(int i : arr) {
            root = tree.insert(root, i);
        }
        System.out.print("Pre Order : ");
        tree.prePrint(root);
        System.out.print("\nIn Order : ");
        tree.inPrint(root);
        System.out.print("\nPost Order : ");
        tree.postPrint(root);
        System.out.print("\nLevel Order : ");
        tree.levelPrint(root);
        System.out.println("\nAfter deletion :");
        tree.delete(root, 9);
        tree.inPrint(root);
        System.out.printf("\nThis tree is of height %s", tree.getHeight(root));
    }
}