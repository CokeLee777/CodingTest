package baekjoon.dynamicProgramming;

import java.util.*;

public class problem2156 {

    public static int n;
    public static int[] alcohol;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //포도주의 개수 입력받기
        n = sc. nextInt();

        //포도주의 양 입력받기
        alcohol = new int[n+1];
        for(int i = 1; i < n+1; i++){
            int cost = sc.nextInt();
            alcohol[i] = cost;
        }

        //만약 포도주가 1개 또는 2개라면
        if(n == 1 || n == 2){
            int result = 0;
            for (int a : alcohol) {
                result += a;
            }
            System.out.println(result);
            return;
        }

        //다이나믹 테이블 초기화
        dp = new int[n+1];
        dp[1] = alcohol[1];
        dp[2] = alcohol[1] + alcohol[2];
        //다이나믹 프로그래밍 수행
        for(int i = 3; i < n+1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + alcohol[i]);
        }

        System.out.println(dp[n]);
    }
}
