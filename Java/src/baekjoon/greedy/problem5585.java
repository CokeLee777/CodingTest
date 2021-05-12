package baekjoon.greedy;

import java.util.*;

public class problem5585 {

    public static int n;
    public static int[] coins = {500,100,50,10,5,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //타로가 지불할 돈
        n = sc.nextInt();
        //거슬러 줘야 하는 돈
        int rest = 1000 - n;
        //거슬러 줘야하는 잔돈의 개수
        int cnt = 0;

        for (int coin : coins) {
            //거스름돈이 거슬러 줘야하는 돈 보다 크다면 무시
            if(coin > rest) continue;
            //아니라면 수행
            cnt += rest / coin;
            rest %= coin;

            //다 거슬러 주었다면 종료
            if(rest == 0){
                System.out.println(cnt);
                break;
            }
        }
    }

}
