package Arrays.MajorityElement;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 *
 * Boyer-Moore Voting Algorithm
 */
public class One {
    public static int majority(int[] nums){
        int n = nums.length;
        int num = nums[0], count =0;
        for(int i=0;i<n;i++){
            if(nums[i]==num) count++;
            else if(count==0){
                num = nums[i];
                count =1;
            }
            else count--;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(majority(new int[]{3,2,3}));
    }
}
