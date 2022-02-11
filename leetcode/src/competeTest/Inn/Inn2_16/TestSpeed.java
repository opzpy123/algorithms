package competeTest.Inn.Inn2_16;

import java.util.Arrays;

public class TestSpeed {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        int randomNumber = (int)(Math.random()*1000+1);//随机1-1000的整数
        for(int i=0;i<arr.length;i++) {
            arr[i] = randomNumber;
            randomNumber = (int)(Math.random()*1000+1);
        }
        long l = System.currentTimeMillis();
        System.out.println(Arrays.toString(LeftInversions_indirectSort.computeL(arr)));
        System.out.println(System.currentTimeMillis()-l);

        long x = System.currentTimeMillis();
        LeftInversions_pairsSort.computeL(arr);
        System.out.println(System.currentTimeMillis()-x);


    }
}
