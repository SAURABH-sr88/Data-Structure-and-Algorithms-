package DSA.DynamicProgramming;

public class FibonacciSeries {
    public static int counter = 0;
    public static int Fibonacci(int n){
        counter++;
        if (n == 0 || n == 1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 40;
        int fibonacci = Fibonacci(n);
        System.out.println(n+"th position of Fibonacci series :"+fibonacci);
        System.out.println(counter);
    }
}
