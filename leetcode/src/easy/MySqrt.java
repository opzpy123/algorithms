package easy;

public class MySqrt {
    public int mySqrt(int x) {
        int r = x;

        while (Math.pow(r,2)>x) {
            r = ((r + x / r) / 2) | 0;
        }

        return r;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(10));
        System.out.println(mySqrt.mySqrt(11));
        System.out.println(mySqrt.mySqrt(12));
        System.out.println(mySqrt.mySqrt(15));
    }
}
