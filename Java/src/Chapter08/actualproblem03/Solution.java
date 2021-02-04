package Chapter08.actualproblem03;

import java.util.*;

public class Solution {
    public static int[] arr = new int[101];

    public static int[] store;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //식량창고 갯수 입력받기
        int n = sc.nextInt();
        //각 식량창고에 저장된 식량의 갯수 입력 받기
        store = new int[n];
        for(int i = 0; i < n; i++) store[i] = sc.nextInt();

        //다이나믹 프로그래밍 진행 보텀업
        arr[0] = store[0];
        arr[1] = Math.max(store[0], store[1]);
        for(int i = 2; i < n; i++){
            //현재 위치까지의 식량창고중에서(3개의 식량창고) 두칸떨어진 식량창고의 합과 중간 식량창고와 비교해서 큰 값으로 값을 삽입
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + store[i]);
        }

        System.out.println(arr[n-1]);
    }
}
