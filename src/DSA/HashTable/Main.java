package DSA.HashTable;

public class Main {
    public static void main(String[] args) {
        hashTable hashTable = new hashTable();
        hashTable.set("saurabh", 1000);
        hashTable.set("Saurabh", 0);
//        System.out.println(hashTable.get("saurabh"));
//        System.out.println(hashTable.get("Saurabh"));
//        System.out.println(hashTable.get("SAURABH"));
//        hashTable.PrintTable();
        System.out.println(hashTable.keys());
    }
}
