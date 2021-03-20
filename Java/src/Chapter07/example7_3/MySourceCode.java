package Chapter07.example7_3;

import java.util.*;

public class MySourceCode {

    public static int[] arr;
    public static int n;
    public static int target;

    //재귀함수로 구현한 이진탐색 메서드
    public static int binarySearch(int start, int end, int target){
        while(start <= end){
            //중간점 지정
            int mid = (start + end) / 2;
            //타겟이 중간값보다 작다면
            if(target < arr[mid]){
                end = mid - 1;
            } else if (target == arr[mid]) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        //찾는 원소가 없다면 -1 반환
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //데이터의 갯수 입력받기
        n = sc.nextInt();
        target = sc.nextInt();

        //데이터를 담을 배열
        arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int targetIndex = binarySearch(0, n - 1, target);

        if(targetIndex == -1){
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println("targetIndex = " + (targetIndex + 1));
        }


    }
}
