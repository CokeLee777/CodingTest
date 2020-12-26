package Chapter03.actualproblem03;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //공백을 기준으로 카드들이 놓인 행의 개수 n, 열의 개수 m을 입력받는다.
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int result = 0;

        //카드에 적힌 각 행,열의 숫자를 입력받는다.
        for(int i = 0; i < n; i++){
            //가장 작은 수를 최대값으로 설정해놓음
            int min_value = 10001;
            for(int j = 0; j < m; j++){
                int input = scanner.nextInt();
                min_value = Math.min(min_value,input);  //둘 중에 작은 값을 대입
            }
            result = Math.max(min_value,result);    //결과값은 큰 값 대입
        }
        System.out.println(result);
    }
}
