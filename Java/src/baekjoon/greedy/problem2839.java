package baekjoon.greedy;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/2839
 */
public class problem2839 {

    public static int n;
    public static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //배달해야하는 설탕의 무게
        n = sc.nextInt();

        int cnt = INF;
        int fiveCnt = 0;
        while(n - 5 * fiveCnt >= 0){

            //무게가 5인 봉지에 우선 담는다
            if((n - 5 * fiveCnt) % 3 == 0){
                cnt = Math.min(cnt, fiveCnt + (n - 5 * fiveCnt) / 3);
            }

            fiveCnt += 1;
        }

        if(cnt == INF) System.out.println(-1);
        else System.out.println(cnt);

    }
}
