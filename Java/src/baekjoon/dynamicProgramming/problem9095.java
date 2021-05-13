package baekjoon.dynamicProgramming;

import java.util.*;

public class problem9095 {

    public static int t;
    public static int[] results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스의 개수 입력받기
        t = sc.nextInt();
        results = new int[t];

        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            //n이 1,2,3 중 하나일 때
            if(n == 1){
                results[i] = 1;
                continue;
            }
            if(n == 2){
                results[i] = 2;
                continue;
            }
            if(n == 3){
                results[i] = 4;
                continue;
            }
            //dp테이블 초기화
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            //다이나믹 프로그래밍 수행
            for(int j = 4; j < n+1; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            results[i] = dp[n];
        }

        for (int result : results) {
            System.out.println(result);
        }
    }
}
