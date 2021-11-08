package Chapter11.problem04;

import java.util.Arrays;
import java.util.Scanner;

public class MySourceCode2 {

    public static final int INF = (int)1e9;
    public static int n;
    public static int[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int target = 1;

        n = sc.nextInt();
        coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        for (int coin : coins) {
            if(target < coin) break;
            target += coin;
        }

        System.out.println("target = " + target);
    }
}
