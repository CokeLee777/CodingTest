package Chapter07.actualproblem03;

import java.util.*;

public class MySourceCode {
    //떡의 갯수, 손님이 요청한 떡의 길이
    public static int n, m;
    //떡들을 담을 배열
    public static int[] arr;
    //결과를 담을 변수
    public static int result = 0;

    public static int binarySearch(int start, int end, int target){

        while(start <= end){
            //중간 값
            int mid = (start + end) / 2;
            //떡 자르기
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                int cut = arr[i] - mid;
                if(cut > 0){
                    sum += cut;
                }
            }
            //자른 길이가 요청한 떡의 길이보다 크거나 같다면
            if(sum >= target) {
                start = mid + 1;
                result = mid;
            }
            //자른 길이가 요청한 떡의 길이보다 작다면
            else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //떡의 개수 입력받기
        n = sc.nextInt();
        //요청한 떡의 길이 입력받기
        m = sc.nextInt();
        //떡의 개별 높이 입력받기
        arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        result = binarySearch(arr[0], arr[n-1], m);

        System.out.println("result = " + result);
    }

}
