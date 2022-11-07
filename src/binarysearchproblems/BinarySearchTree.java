package binarysearchproblems;

public class BinarySearchTree {
        class Node {

            int data;
            Node left, right;

            Node(int d)
            {
                data = d;
                left = right = null;
            }
        }
        Node root;
        BinarySearchTree() {
            root = null;
        }

        void inorder() {
            inorderUtil(this.root);
        }

        void inorderUtil(Node node) {
            if (node == null)
                return;

            inorderUtil(node.left);
            System.out.print(node.data + " ");
            inorderUtil(node.right);
        }

        public void insert(int data) {
            this.root = this.insertRec(this.root, data);
        }

        Node insertRec(Node node, int data) {
            if (node == null) {
                this.root = new Node(data);
                return this.root;
            }

            if (data <= node.data) {
                node.left = this.insertRec(node.left, data);
            } else {
                node.right = this.insertRec(node.right, data);
            }
            return node;
        }

        public class Sum {
            int sum = 0;
        }

        public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTree();

            tree.insert(56);
            tree.insert(30);
            tree.insert(70);
            tree.inorder();
        }
    }

