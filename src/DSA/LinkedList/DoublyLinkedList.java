package DSA.LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }
    }

    public DoublyLinkedList(int data){
        Node node = new Node(data);
        head = node;
        tail = node;
        length = 1;
    }

    public void PrintList (){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void append(int data){
        Node node = new Node(data);
        if (length == 0){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

    public Node RemoveLast(){
        if (length == 0) return null ;
        if (length == 1){
            head = null;
            tail = null;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void prepend(int data){
        Node node = new Node(data);
        if (length == 0){
            head = node;
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
    }

    public Node RemoveFirst(){
        if (length == 0) return null ;
        if (length == 1){
            head = null;
            tail = null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index){
        if (index < 0 || index >= length ) return null;
        Node temp = head;
        if (index <= length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else {
            temp = tail;
            for (int i = length-1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public Boolean set(int index , int data){
        if (index < 0 || index >= length) return false;
        Node temp = get(index);
        if (temp != null){
            temp.data = data;
            return true;
        }
        return false;
    }

    public Boolean insert(int index, int data){
        if (index < 0 || index > length) return false;
        if (index == 0){
            prepend(data);
            return true;
        }
        if (index == length){
            append(data);
            return true;
        }
        Node node = new Node(data);
        Node temp = get(index-1);
        Node after = temp.next;
        node.next = after;
        node.prev = temp;
        temp.next = node;
        after.prev = node;
        return true;

    }

    public Node Remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == 0){
            return RemoveFirst();
        }
        if (index == length-1){
            return RemoveLast();
        }
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        length--;
        return temp;
    }
}
