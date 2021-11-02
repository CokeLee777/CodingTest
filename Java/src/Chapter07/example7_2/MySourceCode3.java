package Chapter07.example7_2;

import java.util.Scanner;

/**
 * 이진탐색: 반으로 쪼개면서 탐색하기
 * 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘
 */
public class MySourceCode3 {

    public static int[] arr = {0,2,4,6,8,10,12,14,16,18};

    public static int binarySearch(int target, int start, int end){
        //찾는 원소가 없다면 -1 반환
        if(start > end) return -1;

        //중간값
        int mid = (start + end) / 2;

        if(arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(target, start, mid-1);
        else return binarySearch(target, mid+1, end);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        int result = binarySearch(target, 0, arr.length);

        System.out.println("result = " + result);
    }
}
