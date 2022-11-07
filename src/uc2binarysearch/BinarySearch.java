package uc2binarysearch;

public class BinarySearch {
        public class BNode {
            int data;
            BNode left, right;
            public BNode(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }


        }
        BNode root;
        public BinarySearch() {
            root = null;
        }
        void inorder() {
            inorderUtil(this.root);
        }

        void inorderUtil(BNode node) {
            if(node == null)
                return;

            inorderUtil(node.left);
            System.out.println(node.data + " ");
            inorderUtil(node.right);
        }

        public void insert(int data) {
            this.root = this.insertRec(this.root, data);
        }

        BNode insertRec(BNode node , int data){

            if(node == null) {
                this.root = new BNode(data);
                return this.root;
            }

            if(data <= node.data) {
                node.left = this.insertRec(node.left, data);
            }
            else {
                node.right = this.insertRec(node.right, data);
            }
            return node;
        }

        public static void main(String [] args) {
            BinarySearch tree = new BinarySearch();
            tree.insert(56);
            tree.insert(30);
            tree.insert(70);
            tree.insert(22);
            tree.insert(40);
            tree.insert(60);
            tree.insert(95);
            tree.insert(11);
            tree.insert(65);
            tree.insert(3);
            tree.insert(16);
            tree.insert(63);
            tree.insert(67);


            tree.inorder();
        }

    }

