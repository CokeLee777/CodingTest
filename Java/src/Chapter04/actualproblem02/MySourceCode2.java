package Chapter04.actualproblem02;

import java.util.*;

public class MySourceCode2 {

    public static int[][] moveTypes = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String now = sc.next();
        int nowX = now.charAt(0) - 'a' + 1;
        int nowY = now.charAt(1) - '0';

        int result = 0;

        for (int[] moveType : moveTypes) {
            int nx = nowX + moveType[0];
            int ny = nowY + moveType[1];

            if(nx < 1 || nx > 8 || ny < 1 || ny > 8) continue;
            else result += 1;
        }

        System.out.println("result = " + result);
    }
}
