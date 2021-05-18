package baekjoon.dynamicProgramming;

import java.util.*;

public class problem2579 {

    public static int n;
    public static int[] stairs;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //계단의 개수 입력받기
        n = sc.nextInt();
        //각 계단의 비용 입력받기
        stairs = new int[n+1];
        for(int i = 1; i < n+1; i++){
            int cost = sc.nextInt();
            stairs[i] = cost;
        }

        //만약 계단의 개수가 1,2개라면
        if(n == 1 || n == 2){
            int result = 0;
            for (int stair : stairs) {
                result += stair;
            }
            System.out.println(result);
            return;
        }

        //다이나믹 프로그래밍 수행(보텀업)
        dp = new int[n+1];
        dp[1] = stairs[1];
        dp[2] = dp[1] + stairs[2];
        for(int i = 3; i < n+1; i++){
            dp[i] = stairs[i] + Math.max(dp[i-3] + stairs[i-1], dp[i-2]);
        }

        System.out.println(dp[n]);
    }
}
