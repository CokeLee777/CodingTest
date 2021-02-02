package Chapter07.actualproblem03;

import java.util.*;

public class MySourceCode {
    //떡의 갯수, 손님이 요청한 떡의 길이
    public static int n, m;
    //떡들을 담을 배열
    public static int[] arr;
    //결과를 담을 변수
    public static int result = 0;

    public static int binarySearch(int[] arr, int target, int start, int end){
        int sum = 0;
        //떡을 타겟만큼 자르지 못할 때
        if(start > end) return result;
        //중간 값
        int mid = (start + end) / 2;
        //떡 자르기

        for(int i = 0; i < arr.length; i++){
            //떡의 길이가 중간값보다 크다면 절단
            if(arr[i] > mid) {
                sum += arr[i] - mid;
            }
        }
        //원하는 값보다 작다면
        if(target > sum) return binarySearch(arr, target, start, mid - 1);
        //원하는 값보다 크다면
        else {
            result = mid;
            return binarySearch(arr, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //떡의 갯수 입력받기
        n = sc.nextInt();
        //요청한 떡의 길이 입력받기
        m = sc.nextInt();
        //떡들 담기
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        //떡들 정렬하기
        Arrays.sort(arr);

        int result = binarySearch(arr, m, arr[0], arr[n - 1]);
        System.out.println("result = " + result);

    }

}
