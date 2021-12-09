package Chapter11.problem27;

import java.util.Scanner;

public class MySourceCode2 {

    private static int[] arr;
    private static int n, x;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        binarySearch(0, n-1);

        if(result == 0) System.out.println(-1);
        else System.out.println(result);
    }

    private static void binarySearch(int start, int end) {
        // 찾는 수가 없는 경우
        if(start > end) return;

        int mid = (start + end) / 2;

        //찾는 수보다 큰 경우
        if(arr[mid] > x) binarySearch(start, mid-1);
        else if (arr[mid] == x) {
            result += 1;
            binarySearch(start, mid-1);
            binarySearch(mid+1, end);
        }
        else binarySearch(mid+1, end);
    }
}
