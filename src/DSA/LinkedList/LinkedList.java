package DSA.LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void PrintList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void append(int num){
        Node node = new Node(num);
        if (length == 0){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public Node RemoveLast(){
        if (length == 0)return null;
        Node temp = head;
        Node pre = head;
        while ( temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0){
            tail = null;
            head = null;
        }
        return temp;
    }

    public void prepend(int num){
        Node node = new Node(num);
        if (length == 0){
            head = node;
            tail = node;
        }else {
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node RemoveFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null; // 0-based boundary check
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set (int index, int value){
        Node temp = get(index);
        while (temp != null){
            temp.data = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length) return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node node = new Node(value);
        Node temp = get(index-1);
        node.next = temp.next;
        temp.next = node;
        length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index > length-1) return null;
        if (index == 0){
            return RemoveFirst();
        }
        if (index == length-1){
            return RemoveLast();
        }
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

}

