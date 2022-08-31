package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the
 * clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * <p>
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 */
public class GasStations {
    // brute force approach
    public static int getStartPoint1(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int stopCounts = 0, j = i, fuel = 0;
            while (stopCounts < n) {
                fuel += gas[j % n] - cost[j % n];
                if (fuel < 0) break;
                stopCounts++;
                j++;
            }
            if (stopCounts == n && fuel >= 0) return i;
        }
        return -1;
    }

    // optimised
    // instead of checking every index ,after we ran out of fuel, we can skip the useless starts
    // all the starts prior to where our fuel<0 are useless, we can move our start point to the start after that
    public static int getStartPoint2(int[] gas, int[] cost) {
        int n = gas.length;
        int totalFuel = 0, // our total cost after our trip
                fuel = 0,// our tank capacity
                start = 0; // initial start point
        for (int i = 0; i < n; i++) {
            totalFuel += gas[i] - cost[i];
            fuel += gas[i] - cost[i];
            if (fuel < 0) {
                fuel = 0;
                start = i + 1;
            }
        }
        return totalFuel >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.println(getStartPoint2(gas, cost));
    }
}
