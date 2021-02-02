package Chapter07.actualproblem02;

import java.util.*;

public class MySourceCode {
    //매장의 부품갯수 n, 손님이 찾는 부품갯수 m
    public static int n, m;
    //매장의 부품 리스트, 손님의 부품 리스트
    public static int[] store;
    public static int[] client;

    public static int binarySearch(int target, int start, int end){
        //찾는 데이터가 없으면 -1 반환
        if(start > end) return -1;
        //중간 값
        int mid = (start + end) / 2;
        //이진 탐색 시작
        if(target == store[mid]) return mid;
        else if(target > store[mid]) return binarySearch(target, mid + 1, end);
        else return binarySearch(target, start, mid - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //매장정보 입력
        n = sc.nextInt();
        store = new int[n];
        for(int i = 0; i < n; i++){
            store[i] = sc.nextInt();
        }
        //손님정보 입력
        m = sc.nextInt();
        client = new int[m];
        for(int i = 0; i < m; i++){
            client[i] = sc.nextInt();
        }
        //배열 정렬하기
        Arrays.sort(store);
        Arrays.sort(client);

        int[] result = new int[m];

        //이진탐색 수행
        for(int i = 0; i < m; i++){
            result[i] = binarySearch(client[i], 0, n - 1);
        }

        for(int r: result){
            //찾는 물건이 있으면
            if(r != -1) System.out.print("yes ");
                //찾는 물건이 없으면
            else System.out.print("no ");
        }

    }

}
