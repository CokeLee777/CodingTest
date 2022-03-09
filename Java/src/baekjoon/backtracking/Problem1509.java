package baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem1509 {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //문자열 입력받기
        String s = br.readLine();
        //길이가 1또는 2라면
        if(s.length() == 1){
            bw.write(1 + "\n");
            bw.flush();
            return;
        }
        if(s.length() == 2){
            int result = s.charAt(0) == s.charAt(1) ? 1 : 2;
            bw.write(result + "\n");
            bw.flush();
            return;
        }
        //보텀업 다이나믹프로그래밍 수행
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == s.charAt(1) ? 1 : 2);
        for(int i = 2; i < s.length(); i++){
//            dp[i] = Math.min(dp[i-1] + 1, isPalindrome(s.substring(0, i+1), i));
        }


        bw.write(dp[s.length()-1] + "\n");
        bw.flush();
    }
}
