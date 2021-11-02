package Chapter07.actualproblem03;

import java.util.*;

public class MySourceCode3 {

    public static int n, m;
    public static int[] ttuk;
    public static int mid;

    public static int binarySearch(int target, int start, int end){
        if(start >= end) return mid;

        mid = (start + end) / 2;

        //자른 떡의 길이
        int result = 0;
        for(int t: ttuk){
            if(t - mid > 0) result += (t-mid);
        }
        //요청한 떡의 길이를 못미친다면
        if(target > result) return binarySearch(target, start, mid-1);
        //요청한 떡의 길이에 미친다면
        else return binarySearch(target, mid+1, end);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //떡의 개수 입력받기
        m = sc.nextInt();   //요청한 떡의 길이 입력받기
        //떡의 개별 높이 입력받기
        ttuk = new int[n];
        for(int i = 0; i < n; i++){
            ttuk[i] = sc.nextInt();
        }
        //떡들 정렬하기
        Arrays.sort(ttuk);

        int result = binarySearch(m, ttuk[0], ttuk[n-1]);

        System.out.println(result);
    }
}
