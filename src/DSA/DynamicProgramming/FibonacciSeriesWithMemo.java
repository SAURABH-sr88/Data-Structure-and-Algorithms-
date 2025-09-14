package DSA.DynamicProgramming;

public class FibonacciSeriesWithMemo {

    static Integer[] memo = new Integer[100];
    public static int counter = 0;
    public static int Fibonacci(int n){
        counter++;
        if (memo[n] != null){
            return memo[n];
        }
        if (n == 0 || n == 1){
            return n;
        }
        memo[n] = Fibonacci(n-1) + Fibonacci(n-2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 70;
        int fibonacci = Fibonacci(n);
        System.out.println(n+"th position of Fibonacci series :"+fibonacci);
        System.out.println("Counter :" + counter);
    }

}
