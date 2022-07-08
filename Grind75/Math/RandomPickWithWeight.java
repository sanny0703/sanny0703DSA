package Math;

import java.util.Random;

/**
 * You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.
 * <p>
 * You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).
 * <p>
 * For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 */
public class RandomPickWithWeight {
    int[] weightsRange;
    Random random;

    public RandomPickWithWeight(int[] weight) {
        for (int i = 1; i < weight.length; i++) {
            weight[i] = weight[i] + weight[i - 1];
        }
        weightsRange = weight;
        random = new Random();
    }

    public int pickIndex() {
        // +1 for 1 indexed
        int idx = random.nextInt(weightsRange[weightsRange.length - 1]) + 1;
        int lo = 0, hi = weightsRange.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (weightsRange[mid] == idx)
                return mid;
            else if (weightsRange[mid] > idx)
                hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;//the next range
    }
}
