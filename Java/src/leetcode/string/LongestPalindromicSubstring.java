package leetcode.string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static class Solution{

        public String longestPalindrome(String s) {
            //현재 제일 길이가 긴 앞뒤가 똑같은 문자열
            String max = s.substring(0, 1);

            //앞에서부터 앞뒤가 똑같은 문자열 찾기
            for(int i = 0; i < s.length(); i++){
                char now = s.charAt(i);
                //문자열의 길이가 짝수라면
                if(i+1 < s.length() && now == s.charAt(i+1)){
                    String palindrome = findPalindrome(s, i, i+1);
                    if(max.length() < palindrome.length()) max = palindrome;
                }
                //문자열의 길이가 홀수라면
                if(i+2 < s.length() && now == s.charAt(i+2)){
                    String palindrome = findPalindrome(s, i, i+2);
                    if(max.length() < palindrome.length()) max = palindrome;
                }
            }

            return max;
        }

        private String findPalindrome(String s, int left, int right){
            char[] charArr = s.toCharArray();

            while(left >= 0 && right < charArr.length && charArr[left] == charArr[right]){
                left--; right++;
            }

            return s.substring(left+1, right);
        }
    }


}
