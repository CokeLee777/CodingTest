package Chapter07.actualproblem02;

import java.util.*;

public class MySourceCode3 {

    public static int n, m;
    public static int[] store, orders;

    public static String binarySearch(int target, int start, int end){
        //찾는 부품이 없으면 no 출력
        if(start > end) return "no";

        int mid = (start + end) / 2;

        //찾는 부품이 있다면 yes 출력
        if(store[mid] == target) return "yes";
        else if(store[mid] > target) return binarySearch(target, start, mid-1);
        else return binarySearch(target, mid+1, end);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        store = new int[n];
        for(int i = 0; i < n; i++){
            store[i] = sc.nextInt();
        }
        m = sc.nextInt();
        orders = new int[m];
        for(int i = 0; i < m; i++){
            orders[i] = sc.nextInt();
        }

        //가게 부품과 손님이 요청한 부품 정렬
        Arrays.sort(store);
        Arrays.sort(orders);

        for (int order : orders) {
            String result = binarySearch(order, 0, store.length);
            System.out.print(result + " ");
        }
    }
}
