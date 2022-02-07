package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public static class MySourceCode{

        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> temps = new ArrayList<>();
            backTrack(results, temps, candidates, target, 0);
            return results;
        }

        private static void backTrack(List<List<Integer>> results, List<Integer> temps, int[] candidates, int target, int left){

            if(target > 0){
                for(int i = left; i < candidates.length && target >= candidates[i]; i++){
                    temps.add(candidates[i]);
                    backTrack(results, temps, candidates, target - candidates[i], i);
                    temps.remove(temps.size() - 1);
                }
            } else if(target == 0) {
                results.add(new ArrayList<>(temps));
            }
        }
    }
}
