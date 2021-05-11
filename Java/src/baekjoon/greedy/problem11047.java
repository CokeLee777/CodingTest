package baekjoon.greedy;

import java.util.*;

public class problem11047 {

    public static int n, k;
    public static Integer[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //갖고있는 동전의 개수와 필요한 동전 가치를 입력받기
        n = sc.nextInt();
        k = sc.nextInt();

        //동전들 종류별로 입력받기
        coins = new Integer[n];
        for(int i = 0; i < n; i++){
            int coin = sc.nextInt();

            if(k < coin) coins[i] = 0;
            else coins[i] = coin;
        }

        //동전 내림차순으로 정렬
        Arrays.sort(coins, Collections.reverseOrder());

        int rest = k;
        int cnt = 0;

        //높은 동전부터 수행
        for (Integer coin : coins) {
            cnt += rest / coin;
            rest %= coin;

            //다 만들었으면 종료
            if(rest == 0){
                System.out.println(cnt);
                break;
            }
        }
    }
}
