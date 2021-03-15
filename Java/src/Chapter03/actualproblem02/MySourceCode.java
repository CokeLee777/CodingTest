package Chapter03.actualproblem02;

import java.util.*;

public class MySourceCode {

    public static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //입력받을 자연수의 개수
        int m = sc.nextInt();   //더할 자연수의 개수
        int k = sc.nextInt();   //같은수가 연속해서 더할수 있는 횟수

        //n개의 자연수를 입력받는다
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        //배열을 정렬한다.
        Arrays.sort(arr);

        int cons = 0;       //연속해서 더하는 횟수
        int result = 0;     //결과값
        //m개의 자연수를 조건에 맞게 더한다.
        for(int i = 0; i < m; i++){
            //특정 인덱스의 연속 더함이 k를 넘지 않으면
            if(cons < k){
                cons += 1;
                result += arr[n-1];
            } else {
                cons = 0;
                result += arr[n-2];
            }
        }

        System.out.println("result = " + result);
    }
}
