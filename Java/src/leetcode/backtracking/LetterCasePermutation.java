package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static class Solution{
        public static List<String> letterCasePermutation(String s) {
            List<String> results = new ArrayList<>();
            backTracking(results, s.toCharArray(), 0);
            return results;
        }

        public static void backTracking(List<String> results, char[] charArr, int i){
            if(i == charArr.length){
                results.add(String.valueOf(charArr));
            } else {
                //알파벳 이라면
                if(Character.isLetter(charArr[i])){
                    //대문자로 바꾸거나 소문자로 바꿔서 백트래킹
                    charArr[i] = Character.toUpperCase(charArr[i]);
                    backTracking(results, charArr, i+1);
                    charArr[i] = Character.toLowerCase(charArr[i]);
                    backTracking(results, charArr, i+1);
                } else {
                    //알파벳이 아니라면 건너뛴다.
                    backTracking(results, charArr, i+1);
                }

            }
        }
    }
}
