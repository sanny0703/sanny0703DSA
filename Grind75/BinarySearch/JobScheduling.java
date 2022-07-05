package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * <p>
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 * <p>
 * If you choose a job that ends at time X you will be able to start another job that starts at time X
 * <p>
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 */
public class JobScheduling {
    public static int maxProfit(int[] startTime, int[] endTime, int[] profits) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        // organise the input into jobs
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profits[i]);
        }
        //sort the jobs based on end time
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            // for each job find all those jobs  which do not clash with it
            int profit = jobs[i].profit;
            // find the job before current which can be completed without clash and dp takes care of recursion
            int l = binarySearch(jobs, i);
            if (l != -1)
                profit += dp[l];
            dp[i] = Math.max(profit, dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end > jobs[index].start)
                    return mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return -1;
    }

    static class Job {
        int start, end, profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
    }
}
