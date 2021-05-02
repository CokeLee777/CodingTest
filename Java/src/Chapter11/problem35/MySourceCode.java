package Chapter11.problem35;

import java.util.*;

public class MySourceCode {

    public static int[] dp = new int[1000];
    public static int n;
    public static int value = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dp[0] = 1;

        for(int i = 1; i < n; i++){
            //못생긴 수 찾기
            while(value % 2 != 0 && value % 3 != 0 && value % 5 != 0){
                value += 1;
            }
            dp[i] = value;
            value += 1;
        }

        System.out.println(dp[n-1]);
    }
}
