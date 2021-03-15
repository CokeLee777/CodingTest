package Chapter03.actualproblem03;

import java.util.*;

public class MySourceCode {

    public static int[] row;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //숫자 카드들이 놓인 행의 개수 n 입력받기
        int m = sc.nextInt();   //숫자 카드들이 놓인 열의 개수 m 입력받기

        //카드의 적힌 숫자 입력받기
        row = new int[n];
        for(int i = 0; i < n; i++){
            int min_value = 10001;
            for(int j = 0; j < m; j++){
                int now = sc.nextInt();
                min_value = Math.min(min_value, now);
            }
            row[i] = min_value;
        }

        //세개의 행 중 최대값 찾기
        Arrays.sort(row);

        System.out.println(row[n-1]);

    }
}
