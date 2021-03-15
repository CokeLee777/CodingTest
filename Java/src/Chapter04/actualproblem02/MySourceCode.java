package Chapter04.actualproblem02;

import java.util.*;

public class MySourceCode {

    public static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    public static int[] dy = {-1,1,-2,2,-2,2,-1,1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //현재 나이트의 위치 입력받기
        String now = sc.nextLine();
        int x = now.charAt(0) - '0' - 48;
        int y = now.charAt(1) - '0';

        int result = 0;
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //이동 여부
            if(nx < 1 || nx > 8 || ny < 1 || ny > 8) continue;
            else result++;
        }

        System.out.println("result = " + result);
    }
}
