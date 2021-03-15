package Chapter03.example3_1;

import java.util.*;

public class MySourceCode {

    public static int[] coins = {500, 100, 50, 10};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //거슬러 줘야하는 돈
        int count = 0;          //거슬러 줘야하는 돈의 최소 개수

        for(int coin: coins){
            count += (n / coin);
            n %= coin;           //거슬러 주고 남은 돈

            if(n == 0) break;       //거슬러 줄 돈이 없으면 종료
        }

        System.out.println("count = " + count);
    }
}
