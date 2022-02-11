package easy;

public class MaxProfit {
    public int maxProfit1(int[] prices) {
        int rs = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] > prices[i])
                    rs = Math.max(prices[j] - prices[i], rs);
            }
        }
        return rs;
    }

    public int maxProfit(int[] prices) {
        int rs = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]) rs += prices[i+1] - prices[i];
        }
        return rs;
    }


    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
