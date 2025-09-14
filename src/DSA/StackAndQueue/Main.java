package DSA.StackAndQueue;

public class Main {
    public static void main(String[] args) {
//        Stack stack = new Stack(9);
//        stack.push(2);
//        stack.push(2);
//        stack.pop();
//        stack.PrintStack();
          Queue queue = new Queue(120);
          queue.Enqueue(121);
          queue.Enqueue(121);
          queue.Dequeue();
          queue.PrintQueue();
    }
}
