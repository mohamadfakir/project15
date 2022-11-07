package uc3hashtable;

public class HashTable {

        static class HMNode {
            String key;
            int val;
            HMNode next;
            HMNode(String key, int val)
            {
                this.key = key;
                this.val = val;
                this.next = null;
            }
        }

        HMNode head = null;
        HMNode tail = null;
        public void addToHT(String data, int occurrence)
        {
            HMNode newNode = new HMNode(data, occurrence);
            if (head == null)
            {

                head = newNode;
            }
            else
            {
                tail.next = newNode;
                newNode.next = null;
            }
            tail = newNode;
        }
        public void printHT()
        {
            HMNode currNode = head;
            if (head == null)
            {
                System.out.println("HashTable is empty");
            }
            else
            {
                System.out.println("Occurrence of word in Paragraph");
                System.out.println("Key && Occurrence");
                System.out.println("-----------------");
                while (currNode != null)
                {
                    System.out.println(currNode.key + "    " + currNode.val);
                    currNode = currNode.next;
                }
            }
        }
        public void removeFromHT(String keyValue)
        {
            HMNode currNode = head;
            if (head == null)
            {
                System.out.println("HashTable is empty");
            }
            else
            {
                HMNode previous = null;
                while (currNode != null && !currNode.key.equalsIgnoreCase(keyValue))
                {
                    //store the value of current in previous
                    previous = currNode;
                    currNode = currNode.next;
                }
                if (currNode == null)
                {
                    throw new RuntimeException("The key with the given value is not found!!");
                }
                previous.next = currNode.next;
            }
        }
        public static void createHT(String sentence, HashTable hashTable)
        {
            //Creating the string array
            String[] words = sentence.toLowerCase().split(" ");

            int[] temp = new int[words.length];
            int visited = -1;
            for (int i = 0; i < words.length; i++)
            {
                int occurrence = 1;
                for (int j = i + 1; j < words.length; j++)
                {
                    if (words[i].equals(words[j]))
                    {
                        occurrence++;
                        temp[j] = visited;
                    }
                }
                if (temp[i] != visited)
                    temp[i] = occurrence;
            }
            for (int i = 0; i < temp.length; i++)
            {
                if (temp[i] != visited)
                {
                    hashTable.addToHT(words[i], temp[i]);
                }
            }
        }

        public static void main(String[] args) {

            HashTable hashTable = new HashTable();
            String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

            createHT(paragraph,hashTable);
            System.out.println("\nPrinting the original Hash Table below.");

            hashTable.printHT();
            System.out.println();
            hashTable.removeFromHT("avoidable");
            System.out.println("Printing the Hash Table after removing the avoidable word from phrase");
            System.out.println();
            hashTable.printHT();
        }


    }

