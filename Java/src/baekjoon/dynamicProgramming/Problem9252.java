package baekjoon.dynamicProgramming;

import java.io.*;

public class Problem9252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //두개의 문자열 입력받기
        String s1 = br.readLine();
        String s2 = br.readLine();
        //문자열의 길이
        int n = s1.length();
        int m = s2.length();

        //dp테이블 초기화
        int[][] dp = new int[n+1][m+1];

        //다이나믹 프로그래밍 수행 - LCS 길이 구하기
        int ansLen = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                //현재 비교하는 문자열이 같다면
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }//다르다면
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        ansLen = dp[n][m];

        //문자열 구하기
        StringBuilder ansStr = new StringBuilder();
        while(n > 0 && m > 0){
            //현재 비교하는 문자가 같다면
            if(s1.charAt(n-1) == s2.charAt(m-1)){
                ansStr.insert(0, s1.charAt(n-1));
                n--; m--;
            }//아니라면
            else if (dp[n][m] == dp[n-1][m]){
                n--;
            } else if (dp[n][m] == dp[n][m-1]){
                m--;
            }
        }

        bw.write(ansLen + "\n" + ansStr);
        bw.flush();
    }
}
