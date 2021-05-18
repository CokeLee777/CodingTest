package baekjoon.dynamicProgramming;

import java.util.*;

public class problem11726 {

    public static int n;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 타일의 가로 개수 입력받기
        n = sc.nextInt();

        //dp 테이블 초기화
        dp = new int[n+1];
        if(n == 1){
            System.out.println(1);
            return;
        }
        if(n == 2){
            System.out.println(2);
            return;
        }

        dp[1] = 1 % 10007;
        dp[2] = 2 % 10007;
        //다이나믹 프로그래밍 수행
        for(int i = 3; i < n+1; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
