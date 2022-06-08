package MatrixChainMultiplication.problems.EggDropping;

/**
 * <i><b>The problem is not actually to find the critical floor,<br>
 * but merely to decide floors from which eggs should be dropped so that the total number of trials are minimized.</b></i><br><br><br>
 * <h3>Egg Dropping using Recursion</h3>
 * <b>Problem statement</b>: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs<br>
 * to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:<br>
 * <br>
 * If egg breaks at ith floor then it also breaks at all greater floors.<br>
 * If egg does not break at ith floor then it does not break at all lower floors.<br>
 * Unbroken egg can be used again.<br>
 * Note: You have to find minimum trials required to find the critical floor not the critical floor.<br>
 *
 * <code>Example:<br>
 * Input:<br>
 * 4<br>
 * 2<br>
 * <p>
 * Output:<br>
 * Number of trials when number of eggs is 2 and number of floors is 4: 3</code>
 */
public class Recursive {
    public static int minAttempts(int eggs, int floors) {
        if (floors == 0 || floors == 1) return floors;
        if (eggs == 1) return floors;
        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= floors; k++) {
            int temp = 1 // attempt in the Kth floor
                    + Math.max(minAttempts(eggs - 1, k - 1), // if the eggs breaks in Kth floor
                    minAttempts(eggs, floors - k));// if the egg doesn't break in Kth floor
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        //3
        System.out.println(minAttempts(2, 4));
    }
}
