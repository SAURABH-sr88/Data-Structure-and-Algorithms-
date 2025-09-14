package DSA.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, I'm Saurabh Kumar Srivastava ");
//        LinkedList linkedList = new LinkedList(26);
//        linkedList.append(11);
//        linkedList.append(12);
//        linkedList.append(13);
//        linkedList.PrintList();
//        System.out.println();
//        linkedList.reverse();
//        linkedList.PrintList();


        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(6);
        doublyLinkedList.append(3);
        doublyLinkedList.RemoveLast();
        doublyLinkedList.prepend(0);
        doublyLinkedList.prepend(-1);
        doublyLinkedList.RemoveFirst();
        doublyLinkedList.PrintList();
        System.out.println();
        System.out.println(doublyLinkedList.get(4).data);
        System.out.println(doublyLinkedList.set(6,8));
        System.out.println();
        doublyLinkedList.insert(5,5);
        System.out.println(doublyLinkedList.Remove(2).data);
        System.out.println(doublyLinkedList.Remove(2).data);
        System.out.println(doublyLinkedList.Remove(2).data);
        doublyLinkedList.PrintList();
    }
}