package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    public static class MySourceCode{
        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> temps = new ArrayList<>();
            Arrays.sort(candidates);
            backTrack(results, temps, candidates, target, 0);
            return results;
        }

        private static void backTrack(List<List<Integer>> results, List<Integer> temps, int[] candidates, int target, int left){
            if(target == 0){
                results.add(new ArrayList<>(temps));
            }

            for(int i = left; i < candidates.length && target >= 0; i++){
                //중복 방지를 위한 조건
                if(i > left && candidates[i] == candidates[i-1]) continue;
                temps.add(candidates[i]);
                backTrack(results, temps, candidates, target - candidates[i], i+1);
                temps.remove(temps.size() - 1);
            }
        }

        public static void main(String[] args) {
            int[] candidates = {10,1,2,7,6,1,5};
            combinationSum2(candidates, 8);
        }
    }
}
