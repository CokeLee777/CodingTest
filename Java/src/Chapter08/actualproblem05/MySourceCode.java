package Chapter08.actualproblem05;

import java.util.*;

public class MySourceCode {

    public static int[] d; //다이나믹 프로그래밍 하기 위한 저장공간

    public static int[] coins;  //화폐 종류 저장공간

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //화폐의 종류의 갯수 n 과 만들 화폐가치 m 입력받기
        final int n = sc.nextInt();
        final int m = sc.nextInt();

        //화폐 종류 입력받기
        coins = new int[n];
        for(int i = 0; i < n; i++) coins[i] = sc.nextInt();

        //DP 테이블 초기화
        d = new int[m + 1];
        for(int i = 1; i < m + 1; i++){
            d[i] = 10001;
        }

        //다이나믹 프로그래밍 진행 (보텀업)
        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j < m + 1; j++){
                if(d[j - coins[i]] != 10001){
                    d[j] = Math.min(d[j], d[j - coins[i]] + 1);
                }
            }
        }

        if(d[m] == 10001) System.out.println(-1);
        else System.out.println(d[m]);

    }

}
