package Chapter03.actualproblem02;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //배열의 크기 n, 숫자가 더해지는 횟수 m, 최대 연속 합 k 를 공백을 기준으로 입력 받기
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        //숫자들 공백을 기준으로 입력받기
        int[] data = new int[n];
        for(int i = 0; i < data.length; i++){
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);      //배열 정렬하기
        int first = data[n-1];  //배열 내 첫번째로 큰 수
        int second = data[n-2]; //배열 내 두번째로 큰 수

        int result = 0;             //결과를 담을 변수
        while(m > 0){

            for(int i = 0; i < k; i++){
                result += first;
                m -= 1;
                if(m == 0) break;
            }

            if(m == 0) break;
            result += second;
            m -= 1;
        }

        System.out.println(result);
    }
}
