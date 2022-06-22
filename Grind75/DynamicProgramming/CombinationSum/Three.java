package DynamicProgramming.CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *<br>
 * Only numbers 1 through 9 are used.<br>
 * Each number is used at most once.<br>
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * <br>
 * <br>
 * <code>
 * Input: k = 3, n = 9
 * <br>
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * <br>
 * Explanation:
 * <br>
 * 1 + 2 + 6 = 9
 * <br>
 * 1 + 3 + 5 = 9
 * <br>
 * 2 + 3 + 4 = 9
 * <br>
 * There are no other valid combinations.
 * </code>
 */
public class Three {
    public static List<List<Integer>> combinations(int k ,int n){
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        // candidates are already sorted
        List<List<Integer>>ans = new ArrayList<>();
        helper(0,k,candidates,ans,new ArrayList<>(),n);
        return ans;
    }
    public static void helper(int index,int k,int[] candidates,List<List<Integer>>ans,List<Integer>curList,int target){
        if(target ==0){
            if(curList.size()==k)
                ans.add(new ArrayList<>(curList));
            return;
        }
        if(target <0)
            return;
        for(int i = index;i<candidates.length;i++){
            // we don't have to check for duplicates here

            if(candidates[i]<= target){
                curList.add(candidates[i]);
                helper(i+1,k,candidates,ans,curList,target-candidates[i]);
                curList.remove(curList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinations(3,9));
    }
}
