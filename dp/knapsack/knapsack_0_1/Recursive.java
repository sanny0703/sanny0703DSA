package knapsack.knapsack_0_1;

public class Recursive {
    /**
     * As we can see recursion works here and also there are two calls for recursion, so we can check for
     * overlapping sub-problems and also optimal(max profit) is required, so we can go for dp
     *
     * @param weights weights of each element
     * @param values values of each element
     * @param n size of the weights or values array
     * @param W  capacity of the knapsack
     * @return max profit,we can earn by fitting elements in knapsack
     */
    public static int knapsack(int[] weights, int[] values, int n, int W) {
        if (n == 0 || W == 0) return 0;
        else if (weights[n - 1] <= W)
            return Math.max(values[n - 1] + knapsack(weights, values, n - 1, W - weights[n - 1]), knapsack(weights, values, n - 1, W));
        return knapsack(weights, values, n - 1, W);
    }

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapsack(wt, val, n, W));
    }
}
