package Chapter03.actualproblem04;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //어떠한 수 n, 나누는 수 k 를 공백을 기준으로 입력받는다.
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int result = 0;

        while(true){
            //n 이 1이되면 종료
            if(n == 1) break;
            //n 이 k 로 나누어 떨어지지 않으면
            if(n % k != 0){
                n -= 1;
                result += 1;
                continue;
            }
            else{
                n /= k;
                result += 1;
            }
        }
        //결과 값 출력
        System.out.println(result);
    }
}
