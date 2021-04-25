package Chapter11.problem28;

import java.util.*;

public class MySourceCode {

    public static int n;
    public static int[] numbers;

    public static int binarySearch(int start, int end){
        //중간 인덱스
        int mid = (start + end) / 2;
        //종료 조건
        if(start > end) return -1;

        //이진탐색 시작
        if(numbers[mid] < mid) return binarySearch(mid + 1, end);   //인덱스의 값이 인덱스보다 더 작다면
        else if (numbers[mid] == mid) return mid;                   //고정점이라면 반환
        else return binarySearch(start, mid - 1);                   //인덱스의 값이 인덱스보다 더 크다면

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();       //원소의 갯수
        numbers = new int[n];

        //각 원소들 입력받기
        for(int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }

        int result = binarySearch(0, n - 1);

        System.out.println("result = " + result);


    }

}
