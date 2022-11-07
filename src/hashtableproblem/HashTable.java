package hashtableproblem;

public class HashTable {
        static class myMapNode {
            String key;
            int val;
            myMapNode next;
            myMapNode(String key, int val) {
                this.key = key;
                this.val = val;
                this.next = null;
            }
        }

        myMapNode head = null;
        myMapNode tail = null;
        public void addToHT(String data, int occurrence) {
            myMapNode newNode = new myMapNode(data, occurrence);
            if (head == null) {

                head = newNode;
            } else {
                tail.next = newNode;
                newNode.next = null;
            }
            tail = newNode;
        }
        public void printHT() {
            myMapNode currNode = head;
            if (head == null) {
                System.out.println("\tHashTable empty");
                return;
            } else {
                System.out.println("\t Total occurrence of words in Sentence");
                System.out.println("____________________________");
                while (currNode != null) {
                    System.out.println(currNode.key + "    " + currNode.val);
                    currNode = currNode.next;
                }
            }
        }

        public static void createHT(String sentence, HashTable hashTable) {
            String[] words = sentence.toLowerCase().split(" ");

            int[] temp = new int[words.length];
            int visited = -1;
            for (int i = 0; i < words.length; i++) {
                int occurrence = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        occurrence++;
                        temp[j] = visited;
                    }
                }
                if (temp[i] != visited)
                    temp[i] = occurrence;
            }
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != visited) {
                    hashTable.addToHT(words[i], temp[i]);
                }
            }
        }

        public static void main(String[] args) {

            HashTable hashTable = new HashTable();
            String sentence = "To be or not to be";
            createHT(sentence, hashTable);
            System.out.println("\nPrinting the Hash Table");
            hashTable.printHT();
        }

    }
