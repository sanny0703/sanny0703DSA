package Arrays.BuyAndSellStock;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class One {
    // the idea here is to keep track of minSoFar and diff between cur and minSoFar
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int minSoFar = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > minSoFar)
                max = Math.max(max, prices[i] - minSoFar);
            else minSoFar = prices[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
