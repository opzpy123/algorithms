package normal;

import java.util.*;

public class MaxScore {
    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i=0;i<k;++i) {
            sum += cardPoints[i];
        }
        int m = sum;
        for (int i=0;i<k;++i){
            sum += cardPoints[cardPoints.length-1-i] - cardPoints[k-1-i];
            m = sum>m?sum:m;
        }
        return m;
    }
}
