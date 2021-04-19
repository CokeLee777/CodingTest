package Chapter11.problem24;

import java.util.*;

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static int minDistance = INF;
    public static int minIndex;

    public static void binarySearch(int[] locations ,int start, int end){

        //중간 값 인덱스
        int mid = (start + end) / 2;
        //종료조건
        if(start > end) return;

        int prev = 0;
        int sub = 0;
        for(int i = 0; i < locations.length; i++){
            if(i < mid){
                prev += Math.abs(locations[mid] - locations[i]);
            } else {
                sub += Math.abs(locations[mid] - locations[i]);
            }
        }

        minDistance = Math.min(minDistance, prev + sub);
        if(minDistance == prev + sub) minIndex = mid;

        if(prev < sub) binarySearch(locations, mid + 1, end);
        else binarySearch(locations, start, mid - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] locations = new int[n];

        for(int i = 0; i < n; i++){
            locations[i] = sc.nextInt();
        }

        Arrays.sort(locations);

        binarySearch(locations, 0, n - 1);

        System.out.println("minIndex = " + locations[minIndex]);
    }
}
