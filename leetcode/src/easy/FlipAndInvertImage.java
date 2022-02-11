package easy;

import java.util.Arrays;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        FlipAndInvertImage flipAndInvertImage = new FlipAndInvertImage();
//        int[][] ints = flipAndInvertImage.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        int[][] ints = flipAndInvertImage.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}});
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        //对当前子数组中进行左右指针 并判断所有情况
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = M - 1;
            while (left <= right) {
                if (A[i][left] != A[i][right]) {
                    //leetcode上的三目 以及省去了下面的for
//                    A[i][right] = A[i][left] = A[i][left] == 0?1:0;
                    if (A[i][left] == 1) {
                        A[i][left] = 0;
                        A[i][right] = 1;
                    } else {
                        A[i][left] = 1;
                        A[i][right] = 0;
                    }
                }
                left++;
                right--;
            }
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
