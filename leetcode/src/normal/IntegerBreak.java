package normal;

public class IntegerBreak {
    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        integerBreak.integerBreak(2);
        integerBreak.integerBreak(10);

        //4:    2 * 2
        //5:    2 * 3
        //6:    2 * 4
        //7:    3 * 4
        //8:    4 * 4
        //9:    3 * 3 * 3
        //10:   3 * 3 * 4
        //11:   3 * 4 * 4
        //12:   4 * 4 * 4
        //13:   4 * 4 * 2 * 3
    }
    public int integerBreak(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        int a = 1;
        while(n > 4){
            n = n - 3;
            a = a * 3;
        }
        return a * n;
    }
}
