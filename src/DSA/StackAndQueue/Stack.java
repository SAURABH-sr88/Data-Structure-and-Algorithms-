package DSA.StackAndQueue;

public class Stack {
    private Node top;
    private int height;

     public class Node{
         int data;
         Node next;

         public Node(int data){
            this.data = data;
         }
     }

     public Stack(int data){
         Node node = new Node(data);
         top = node;
         height = 1;
     }

     public void PrintStack(){
         Node temp = top;
         while (temp != null){
             System.out.println(temp.data);
             temp = temp.next;
         }
     }

     public void push(int data){
         Node node = new Node(data);
         if (height == 0){
             top =node;
         }else {
             node.next = top;
             top = node ;
         }
         height++;
     }

     public Node pop(){
         if (height == 0) return null;
         Node temp = top;
         top = top.next;
         temp.next = null;
         height--;
         return temp;
     }
}
