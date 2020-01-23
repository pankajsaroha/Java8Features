public class Treesort {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /* Node insert(Node root, int data) {
        Node node = new Node(data);
        Node temp = root;
        if(root == null) {
            return node;
        } else {
            while(temp.left != null || temp.right != null) {
                if(temp.data > data) {
                    if(temp.left == null) {
                        temp.left = node;
                        return root;
                    } else {
                        temp = temp.left;
                    }
                } else if (temp.data < data) {
                    if(temp.right == null) {
                        temp.right = node;
                        return root;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            if(temp.left == null && temp.right == null) {
                if(temp.data >= data) {
                    temp.left = node;
                }  else {
                    temp.right = node;
                }
            }
        }
        return root;
    } */

    Node insert(Node root, int data) {
        System.out.print(".");
        Node temp = root;
        Node node = new Node(data);
        if(root == null) {
            return node;
        } else {
            while(temp.left != null || temp.right != null) {
                if(temp.data >= data) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
            if(temp.left == null) {
                temp.left = node;
            } else {
                temp.right = node;
            }
        }
        return root;
    }

    void print(Node root) {
        Node temp = root;
        if(temp != null) {
            print(temp.left);
            System.out.print(temp.data+" ");
            print(temp.right);
        }
    }

    Node insertNode(Node root, int data) {
        Node temp = root;
        Node node = new Node(data);
        if(root == null) {
            root = node;
        } else {
            if(temp.data >= data && temp.left == null) {
                temp.left = node;
            } else if(temp.data < data && temp.right == null) {
                temp.right = node;
            } else {
                if(temp.data >= data) {
                    insertNode(temp.left, data);
                } else {
                    insertNode(temp.right, data);
                }
            }
        }
        return root;
    }

    public static void main(String args[]) {
        Treesort tsort = new Treesort();
        int arr[] = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Node root = null;
        System.out.print("Building binary search tree..");
        for(int i=0; i<arr.length; i++) {
            root = tsort.insert(root, arr[i]);
        }
        System.out.println();
        System.out.print("Treesort: ");
        tsort.print(root);
        System.out.println();
    }
}