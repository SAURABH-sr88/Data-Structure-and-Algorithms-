package DSA.HashTable;

import java.util.ArrayList;

public class hashTable {
    private int size = 7;
    private Node [] dataMap;

    public class Node{
        String key;
        int data;
        Node next;

        public Node(String key, int data){
            this.key = key;
            this.data = data;
        }
    }

    public hashTable(){
        dataMap = new Node[size];
    }

    public void PrintTable(){
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + " : ");
            Node temp = dataMap[i];
            while (temp != null){
                System.out.println("{ " + temp.key + " : " + temp.data + " }");
                temp = temp.next;
            }
        }
    }

    public int hash(String key){
        int hash = 0;
        char[] keyChar = key.toCharArray();
        for (int i = 0; i < keyChar.length; i++) {
            int AsciiValue = keyChar[i];
            hash = (hash + AsciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int data){
        int index = hash(key);
        Node node = new Node(key, data);
        if (dataMap[index] == null){
            dataMap[index] = node;
        }else {
            Node temp = dataMap[index];
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null){
            if (temp.key == key) return temp.data;
            temp = temp.next;
        }
        return -1;
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++){
            Node temp = dataMap[i];
            while (temp != null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }
}
