package leetcode.backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class Subsets2 {

    public static class MySourceCode{
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(results, temp, nums, 0);
            return results;
        }

        public void backTrack(List<List<Integer>> results, List<Integer> temp, int[] nums, int left){
            results.add(new ArrayList<>(temp));

            for(int i = left; i < nums.length; i++){
                if(i-1 >= left && nums[i-1] == nums[i]) continue;
                temp.add(nums[i]);
                backTrack(results, temp, nums, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
