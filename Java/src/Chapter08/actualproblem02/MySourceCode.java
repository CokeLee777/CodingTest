package Chapter08.actualproblem02;

import java.util.*;

public class MySourceCode {

    public static int x;    //정수 x
    public static int[] d;  //다이나믹 테이블

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //정수 x 입력받기
        x = sc.nextInt();
        //다이나믹 테이블 초기화
        d = new int[x+1];

        //보텀업 방식으로 다이나믹 프로그래밍 수행
        for(int i = 2; i <= x; i++){
            //1을 먼저 뺀 방식을 사용
            d[i] = d[i-1] + 1;

            //2로 나누어 지는 경우
            if(i % 2 == 0){
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            //3으로 나누어 지는 경우
            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            //5로 나누어 지는 경우
            if(i % 5 == 0){
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }

        System.out.println(d[x]);
    }

}
