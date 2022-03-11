package baekjoon.dynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            ans.add(tmp);
        }

        //다이나믹 프로그래밍 수행
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++){
            //첫 연산으로 1을 뺀다
            dp[i] = dp[i-1] + 1;
            ans.get(i).addAll(ans.get(i-1));

            //2로 나누어 떨어지거나 3으로 나누어 떨어지면 1을 뺀 연산과 최솟값 비교
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                ans.get(i).clear();
                ans.get(i).add(i);
                ans.get(i).addAll(ans.get(i/3));
            }
            if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                ans.get(i).clear();
                ans.get(i).add(i);
                ans.get(i).addAll(ans.get(i/2));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ans.get(n).size(); i++)
            sb.append(ans.get(n).get(i)).append(" ");

        bw.write(dp[n] + "\n" + sb);
        bw.flush();
    }
}
