package baekjoon.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1509 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        List<String> results = new ArrayList<>();
        backtracking(results, new StringBuilder(), 0, s, 0);
    }

    private static void backtracking(List<String> results, StringBuilder temp, int max, String s, int idx){
        if(idx == s.length()){
            max = Math.max(results.size(), max);
            return;
        }

        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s.substring(idx, i+1), idx, i)){

            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right){
        char[] charArr = s.toCharArray();
        while(left < right){
            if(charArr[left] != charArr[right]) return false;
            left++; right--;
        }
        return true;
    }
}
