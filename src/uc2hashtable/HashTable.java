package uc2hashtable;

    public class HashTable {
        static class MapNode {
            String key;
            int val;
            MapNode next;
            MapNode(String key, int val)
            {
                this.key = key;
                this.val = val;
                this.next = null;
            }
        }

        MapNode head = null;
        MapNode tail = null;

        public void addToHT(String data, int occurrence)
        {
            MapNode newNode = new MapNode(data, occurrence);
            if (head == null) {

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
            MapNode currNode = head;
            if (head == null)
            {
                System.out.println("HashTable is empty");
                return;
            }
            else
            {
                System.out.println("Total occurrence word in Paragraph");
                System.out.println("_______________________");
                while (currNode != null) {
                    System.out.println(currNode.key + "    " + currNode.val);
                    currNode = currNode.next;
                }
            }
        }
        public static void createHT(String sentence, HashTable hashTable)
        {
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

            String paragraph = "Paranoids are not paranoid because they are paranoid \n" +
                    "but because they keep putting themselves deliberately into paranoid avoidable situations";

            createHT(paragraph,hashTable);

            System.out.println("\nPrinting the Hash Table");
            hashTable.printHT();
        }


    }

