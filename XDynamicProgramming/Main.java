package XDynamicProgramming;

public class Main {
    static int counter=0;
    static Integer[] memo = new Integer[100];
    public static int fib(int n){
        counter++;
        if(n==0 || n==1)
            return n;
        return fib(n-1)+ fib(n-2);
    }

    // Memoization
    public static int fib1(int n){
        counter++;
        if(memo[n] != null)
            return memo[n];
        if(n==0 || n==1)
            return n;
        memo[n]=fib1(n-1)+ fib1(n-2);
        return memo[n];
    }

    // bottom up
    public static int fib2(int n){
        int[] bottom = new int[n+1];
        bottom[0]=0;
        bottom[1]=1;
        for(int i=2; i<=n ; i++){
            counter++;
            bottom[i]=bottom[i-1]+bottom[i-2];
        }
        return bottom[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(40));
        System.out.println(counter);
        counter=0;
        System.out.println(fib1(40));
        System.out.println(counter);
        counter=0;
        System.out.println(fib2(40));
        System.out.println(counter);
    }
}
