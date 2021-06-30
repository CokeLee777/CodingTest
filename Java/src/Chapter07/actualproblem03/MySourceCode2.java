package Chapter07.actualproblem03;

import java.util.*;

public class MySourceCode2 {

    public static int n, m;
    public static int[] store;
    public static int maxResult;

    public static int binarySearch(int start, int end, int target){

        if(start > end) return maxResult;

        int mid = (start + end) / 2;
        int sum = 0;

        for (int i : store) {
            int result = i - mid;
            if(result > 0) sum += result;
        }

        if(sum >= target){
            maxResult = mid;
            return binarySearch(mid + 1, end, target);
        } else {
            return binarySearch(start, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        store = new int[n];
        for(int i = 0; i < n; i++){
            store[i] = sc.nextInt();
        }

        Arrays.sort(store);

        int result = binarySearch(store[0], store[n - 1], m);

        System.out.println(result);
    }
}
