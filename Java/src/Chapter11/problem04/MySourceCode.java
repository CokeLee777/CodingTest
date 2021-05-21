package Chapter11.problem04;

import java.util.*;

public class MySourceCode {

    public static int n;
    public static int[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //동전의 개수 입력받기
        n = sc.nextInt();
        //동전 입력받기
        coins = new int[n];
        for(int i = 0; i < n; i++){
            int coin = sc.nextInt();
            coins[i] = coin;
        }

        //동전들 오름차순으로 정렬하기
        Arrays.sort(coins);

        int target = 1;
        for(int coin: coins){
            if(target < coin) break;
            target += coin;
        }

        System.out.println(target);
    }
}
