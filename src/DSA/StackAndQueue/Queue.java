package DSA.StackAndQueue;

public class Queue {
    private Node first;
    private  Node last;
    private int length;

     public class Node{
         int data;
         Node next;

         public Node(int data){
             this.data = data;
         }
     }

     public Queue(int data){
         Node node = new Node(data);
         first = node;
         last = node;
         length = 1;
     }

     public void PrintQueue(){
         Node temp = first;
         while (temp != null){
             System.out.println(temp.data);
             temp = temp.next;
         }
     }

     public void Enqueue(int data){//add in last
         Node node = new Node(data);
         if (length == 0){
             first = node;
             last = node;
         }else {
             last.next = node;
             last = node;
         }
         length++;
     }

     public Node Dequeue(){//removes from start
         if (length == 0) return null;
         Node temp = first;
         if (length == 1){
          first = null;
          last = null;
         }else {
             first = first.next;
             temp.next = null;
         }
         length--;
         return temp;
     }
}
