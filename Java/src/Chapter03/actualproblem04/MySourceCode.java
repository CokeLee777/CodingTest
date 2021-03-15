package Chapter03.actualproblem04;

import java.util.*;

public class MySourceCode {

    public static int[] d;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //어떠한 수 n을 입력받는다
        int k = sc.nextInt();   //나누는 수 k를 입력받는다 n >= k

        d = new int[n+1];       //다익스트라 테이블 생성

        //보텀업 로직 수행
        for(int i = 2; i < n+1; i++){
            //1을 빼는 경우
            d[i] = d[i-1] + 1;
            //k로 나누는 경우, 1을 먼저 뺀 경우와 비교
            if(i % k == 0){
                d[i] = Math.min(d[i], d[i / k]);
            }
        }

        System.out.println(d[n]);
    }
}
