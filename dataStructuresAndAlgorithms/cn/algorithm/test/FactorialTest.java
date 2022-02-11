package test;

public class FactorialTest {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    //求N的阶乘
    public static long factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
