package baekjoon.dynamicProgramming;

import java.io.*;

public class Problem2342 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int[] guide = new int[input.length-1];
        for(int i = 0; i < input.length - 1; i++){
            guide[i] = Integer.parseInt(input[i]);
        }

        //입력이 1개라면
        if(guide.length == 1) {
            bw.write(2 + "\n");
            bw.flush();
            return;
        }

        //가이드에 따라 게임 시작
        int[] dp = new int[guide.length];
        dp[0] = 2;
        int foot1 = guide[0], foot2 = 0;
        for(int i = 1; i < guide.length; i++){
            //거리 측정
            int len1 = Math.abs(foot1 - guide[i]);
            int len2 = Math.abs(foot2 - guide[i]);
            //같은 발판을 다시 밟아야 한다면
            if(foot1 != 0 && len1 == 0){
                foot1 = guide[i];
                dp[i] = dp[i-1] + 1;
                continue;
            }
            if(foot2 != 0 && len2 == 0){
                foot2 = guide[i];
                dp[i] = dp[i-1] + 1;
                continue;
            }
            //아니라면
            if(foot2 == 0){
                foot2 = guide[i];
                dp[i] = dp[i-1] + 2;
                continue;
            }
            //두발 다 중앙에 없다면
            if(len1 == 2 && len2 != 2){
                foot2 = guide[i];
                dp[i] = dp[i-1] + 3;
                continue;
            }
            if(len2 == 2 && len1 != 2){
                foot1 = guide[i];
                dp[i] = dp[i-1] + 3;
            }
        }

        bw.write(dp[guide.length-1] + "\n");
        bw.flush();
    }
}
