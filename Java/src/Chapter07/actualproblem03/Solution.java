package Chapter07.actualproblem03;

import java.util.*;

public class Solution {
    public static int[] array;

    public static int result = 0;

    public static int binarySearch(int[] arr, int target, int start, int end){

        int total = 0;

        //이진탐색이 끝나면 종료
        if(start > end) return result;

        //중간 점
        int mid = (start + end) / 2;

        for(int i = 0; i < arr.length; i++){
            //잘랐을 때의 떡의 양 계산
            if(arr[i] > mid) total += arr[i] - mid;
        }

        if(total < target){ //요청한 떡보다 적은 경우
            return binarySearch(array, target, start, mid - 1);
        } else { //떡의 양이 충분한 경우
            result = mid;
            return binarySearch(array, target, mid + 1, end);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //떡의 갯수와 요청한 떡의 길이 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        //떡의 개별 높이 입력받기
        array = new int[n];
        for(int i = 0; i < n; i++) array[i] = sc.nextInt();
        //떡들을 오름차순으로 정렬
        Arrays.sort(array);

        //떡의 길이의 최대값으로 끝점 설정
        int end = (int)1e9;

        System.out.println(binarySearch(array, m, 0, end));

    }
}
