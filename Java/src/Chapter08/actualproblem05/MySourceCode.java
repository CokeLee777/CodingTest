package Chapter08.actualproblem05;

import java.util.*;

public class MySourceCode {

    public static int[] coins;

    public static int[] d;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //화폐의 갯수 입력
        int n = sc.nextInt();
        //만들 화폐의 가치 입력
        int m = sc.nextInt();
        //가지고있는 화폐 입력 받기
        coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        //d 테이블 초기화
        d = new int[m+1];
        for(int i = 1; i <= m; i++){
            d[i] = 10001;
        }
        //다이나믹 프로그래밍 수행-보텀업
        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j <= m; j++){
                if(d[j - coins[i]] != 10001){
                    d[j] = Math.min(d[j], d[j - coins[i]] + 1);
                }
            }
        }

        if(d[m] == 10001) System.out.println(-1);
        else System.out.println(d[m]);

    }

}
