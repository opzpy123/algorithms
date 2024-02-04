package normal;

import java.util.Arrays;

public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(2736));
        System.out.println(maximumSwap.maximumSwap(9973));
        System.out.println(maximumSwap.maximumSwap(98368));
    }
    public int maximumSwap(int num) {
        String str = num+"";
        String[] split = str.split("");
        int maxIdx = 0;
        Integer maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < split.length; i++) {
            int numI = Integer.parseInt(split[i]);
            if(numI>maxVal){
                maxVal=numI;
                maxIdx=i;
            }
        }
        String temp = split[0];
        split[0]= String.valueOf(maxVal);
        split[maxIdx]=temp;
        StringBuilder res = new StringBuilder("");
        for (String s : split) {
            res.append(s);
        }
        return Integer.parseInt(res.toString());
    }
}
