package competeTest.orther.lanqiaoTest3_5;

/**
 * 20届蓝桥杯题目
 * https://www.zhihu.com/question/425865690
 */
public class A {
    public static void main(String[] args) {
        int count=0;
        for (int i = 1; i <= 2020; i++) {
            for (int j = 1; j <= 2020; j++) {
                if(1==getNumber(i,j)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int getNumber(int x, int y) {
        if(x==y){
            return x;
        }
        int big= Math.max(x, y);
        int small= Math.min(x, y);
        return getNumber(big-small,small);
    }

    public static boolean judgePrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
