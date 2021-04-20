package Chapter11.problem27;

import java.util.*;

public class MySourceCode {

    public static int[] arr;
    public static int n, x;
    public static int count;
    public static boolean[] visited;

    public static int binarySearch(int start, int end, int target){
        //중간점 인덱스
        int mid = (start + end) / 2;
        //찾는 원소가 없다면 종료
        if(start > end) return -1;

        //원소 찾기
        if(arr[mid] > target) return binarySearch(mid + 1, end, target);
        else if (arr[mid] == target && !visited[mid]){
            count += 1;
            visited[mid] = true;
            binarySearch(mid + 1, end, target);
            binarySearch(start, mid - 1, target);
            return count;
        }
        else return binarySearch(start, mid - 1, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        count = binarySearch(0, n - 1, x);

        System.out.println("count = " + count);
    }
}
