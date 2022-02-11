package easy;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(1<<20);
    }
    public int reverseBits(int n) {
        int a=0;
        for(int i=0;i<=31;i++){
            a+=  (1&(n>>i))<<(31-i);
        }
        return a;
    }
}
