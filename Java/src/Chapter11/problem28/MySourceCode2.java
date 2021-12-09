package Chapter11.problem28;

import java.util.Scanner;

public class MySourceCode2 {

    public static int[] arr;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(0, n - 1);

        System.out.println(result);
    }

    private static int binarySearch(int start, int end) {
        //고정점이 없다면 -1출력
        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(arr[mid] > mid) return binarySearch(start, mid-1);
        else if (arr[mid] == mid) return mid;
        else return binarySearch(mid+1, end);
    }
}
