package BacktrackingAndRecursion.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class NoDuplicates {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
         backtrack(nums,ans, new ArrayList<>());
         return  ans;
    }
    public static void  backtrack(int[] nums,List<List<Integer>>ans,List<Integer>curList){
        if(curList.size()==nums.length){
            ans.add(new ArrayList<>(curList));
            return;
        }
        for(int i=0;i< nums.length;i++){
            if(!curList.contains(nums[i])){
                curList.add(nums[i]);
                backtrack(nums,ans,curList);
                curList.remove(curList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
