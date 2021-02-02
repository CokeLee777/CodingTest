package Chapter07.example7_2;

import java.util.*;

public class Solution {
    public static int binarySearch(int[] arr, int target, int start, int end){
        //시작점위치가 끝점위치보다 커지는 경우 종료
        if(start > end) return -1;

        //중간 지점
        int mid = (start + end) / 2;

        if(target == arr[mid]) return mid;
        else if(target > arr[mid]) return binarySearch(arr, target, mid + 1, end);
        else return binarySearch(arr, target, start, mid - 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //원소의 갯수 입력받기
        int n = sc.nextInt();

        int[] array = new int[n];

        //찾을 숫자 입력받기
        int target = sc.nextInt();
        //원소 입력받기
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        int result = binarySearch(array, target, 0, n - 1);

        if(result == -1) System.out.println("찾는 원소가 존재하지 않습니다.");
        else System.out.println(result + 1);

    }
}
