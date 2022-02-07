package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static class Solution{

        public List<String> generateParenthesis(int n) {
            List<String> results = new ArrayList<>();
            backTrack(results, "", 0, 0, n);
            return results;
        }

        private void backTrack(List<String> results, String temp, int open, int close, int n){
            if(temp.length() == n*2){
                results.add(temp);
                return;
            }
            if(open < n) backTrack(results, temp + "(", open + 1, close, n);
            if(close < open) backTrack(results, temp + ")", open, close + 1, n);
        }
    }

}
