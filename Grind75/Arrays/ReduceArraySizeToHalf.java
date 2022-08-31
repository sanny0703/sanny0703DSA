package Arrays;

import java.util.*;

/**
 * You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.
 *<br>
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 *<br>
 * Input: arr = [3,3,3,3,5,5,5,2,2,7]
 * Output: 2
 * Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e. equal to half of the size of the old array).
 * Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
 * <br>
 * <br>
 * Input: arr = [7,7,7,7,7,7]
 * Output: 1
 * Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 */
public class ReduceArraySizeToHalf {
    public static int minSetSize(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums) map.put(num,map.getOrDefault(num,0)+1);
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a->-map.get(a)));
        map.forEach((k,v)->maxHeap.offer(k));
        int n = nums.length,half = n/2;
        int count =0;
        while (n>half){
            int current = maxHeap.poll();
            count++;
            n -= map.get(current);
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        System.out.println(minSetSize(new int[]{7,7,7,7,7,7}));
    }
}
