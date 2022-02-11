package easy;

import java.util.Arrays;

public class DistributeCandies {
    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        System.out.println(distributeCandies.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies.distributeCandies(new int[]{1, 1, 2, 3}));
    }

    public int distributeCandies(int[] candyType) {
        return (int) Math.min(Arrays.stream(candyType).distinct().count(), candyType.length / 2);
    }
}
