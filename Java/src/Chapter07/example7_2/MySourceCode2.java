package Chapter07.example7_2;

import java.util.*;

public class MySourceCode2 {

    public static int[] arr;
    public static int n;
    public static int target;

    public static int binarySearch(int start, int end, int target){

        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] > target) {
            return binarySearch(start, mid - 1, target);
        } else {
            return binarySearch(mid + 1, end, target);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        target = sc.nextInt();

        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int result = binarySearch(0, n, target);

        if(result == -1){
            System.out.println("no result");
        } else {
            System.out.println(result + 1);
        }

    }

}
