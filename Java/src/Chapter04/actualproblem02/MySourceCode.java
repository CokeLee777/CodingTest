package Chapter04.actualproblem02;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //현재 나이트의 위치 입력받기
        String position = scanner.nextLine();
        int x = position.charAt(1) - '0';
        int y = position.charAt(0) - 'a' + 1;
        //말이 이동하는 경우의 수
        int[][] moves = new int[][]{{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        int result = 0;

        for(int[] move: moves){
            int dx = x + move[0];
            int dy = y + move[1];
            if(dx < 1 || dx > 8 || dy < 1 || dy > 8){
                continue;
            }
            else{
                result++;
            }
        }
        System.out.println(result);
    }
}
