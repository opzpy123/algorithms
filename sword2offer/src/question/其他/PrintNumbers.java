package question.其他;

import java.util.Arrays;

public class PrintNumbers {
    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        System.out.println(Arrays.toString(printNumbers.printNumbers(2)));
    }

    public int[] printNumbers(int n) {
        int len = 9;
        for (int i = 1; i < n; i++) {
            len = len * 10 + 9;
        }
        int[] ints = new int[len];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }
}
