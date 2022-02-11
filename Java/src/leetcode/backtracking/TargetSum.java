package leetcode.backtracking;

/**
 * https://leetcode.com/problems/target-sum/
 */
public class TargetSum {

    public static class Solution{
        private int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
            backTrack(nums, 0, target, 0);
            return count;
        }

        private void backTrack(int[] nums, int temp, int target, int idx){
            if(idx == nums.length){
                if(target == temp) count++;
                return;
            }

            backTrack(nums, temp + nums[idx], target, idx + 1);
            backTrack(nums, temp - nums[idx], target, idx + 1);
        }
    }
}
