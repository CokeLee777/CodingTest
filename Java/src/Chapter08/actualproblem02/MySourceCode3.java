package Chapter08.actualproblem02;

import java.util.*;

public class MySourceCode3 {

    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        d = new int[x+1];
        d[2] = 1;
        d[3] = 1;

        for(int i = 4; i <= x; i++){
            //먼저 1을 뺀 연산 횟수를 집어넣는다.
            d[i] = d[i-1] + 1;

            //5로 나누어 떨어진다면
            if(i % 5 == 0) d[i] = Math.min(d[i], d[i/5] + 1);
            //3으로 나누어 떨어진다면
            if(i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
            //2로 나누어 떨어진다면
            if(i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);

        }

        System.out.println(d[x]);
    }
}
