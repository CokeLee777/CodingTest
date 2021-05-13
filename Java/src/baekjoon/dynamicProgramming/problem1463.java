package baekjoon.dynamicProgramming;

import java.util.*;

public class problem1463 {

    public static int n;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //정수 n을 입력받기
        n = sc.nextInt();
        //dp테이블 초기화
        dp = new int[n+1];

        //다이나믹 프로그래밍 수행 보텀업
        for(int i = 2; i < n+1; i++){
            //1빼기 수행
            dp[i] = dp[i-1] + 1;
            //2로 나누어 떨어진다면
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            //3으로 나누어 떨어진다면
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }

        System.out.println(dp[n]);
    }
}
