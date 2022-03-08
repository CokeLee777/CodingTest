package baekjoon.dynamicProgramming;

import java.io.*;

public class Problem11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //수열의 크기 입력받기
        int N = Integer.parseInt(br.readLine());
        //수열 입력받기
        String[] input = br.readLine().split(" ");

        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N];

        int max = 0;
        for(int i = 0; i < N; i++){
            dp[i] = 1;

            //0~i까지 탐색
            for(int j = 0; j < i; j++){
                //j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp + 1보다 작은경우
                if(nums[j] < nums[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(dp[i], max);
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
