package Chapter08.actualproblem03;

import java.util.*;

public class MySourceCode {

    public static int[] arr = new int[101];

    public static int[] store;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //식량창고 갯수 입력받기
        int n = sc.nextInt();
        //식량창고 초기화
        store = new int[n];
        for(int i = 0; i < n; i++){
            store[i] = sc.nextInt();
        }
        arr[0] = store[0];
        arr[1] = Math.max(store[0], store[1]);
        //다이나믹 프로그래밍 수행 - 보텀업
        for(int i = 2; i < n; i++){
            arr[i] = Math.max(arr[i-1], store[i] + arr[i-2]);
        }

        System.out.println("result = " + arr[n-1]);
    }

}
