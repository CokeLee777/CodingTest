package Chapter08.actualproblem03;

import java.util.*;

public class MySourceCode {

    public static int[] store;  //식량창고
    public static int n;        //식량창고의 개수
    public static int[] d;      //다이나믹 테이블

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //식량창고의 개수 입력받기
        n = sc.nextInt();
        //식량창고에 저장된 식량의 개수 입력받기
        store = new int[n];
        for(int i = 0; i < store.length; i++){
            store[i] = sc.nextInt();
        }
        //다이나믹 테이블 초기화
        d = new int[n];
        //첫번째 두번째 까지의 다이나믹 테이블 초기화
        d[0] = store[0];
        d[1] = Math.max(store[0], store[1]);

        //세번째 식량창고부터의 다이나믹 프로그래밍 수행
        for(int i = 2; i < n; i++){
            d[i] = Math.max(d[i-2] + store[i], d[i-1]);
        }

        System.out.println(d[n-1]);
    }

}
