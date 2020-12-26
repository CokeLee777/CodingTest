package Chapter04.example4_1;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //n*n의 정사각형 공간에서 n 의 값 입력받기
        int n = scanner.nextInt();
        scanner.nextLine();
        //여행가 A가 이동할 계획서 내용 입력받기 공백을 기준으로 하나씩 배열에 넣는다.
        String[] plans = scanner.nextLine().split(" ");
        //시작 좌표 초기화
        int x = 0; int y = 0;

        //여행가 A의 이동
        for(String plan: plans){
            if(plan.equals("L")){
                y -= 1;
                if(x < 0 || y < 0 || x > n-1 || y > n-1){
                    y += 1;
                    continue;
                }
            }
            else if(plan.equals("R")){
                y += 1;
                if(x < 0 || y < 0 || x > n-1 || y > n-1){
                    y -= 1;
                    continue;
                }
            }
            else if(plan.equals("U")){
                x -= 1;
                if(x < 0 || y < 0 || x > n-1 || y > n-1){
                    x += 1;
                    continue;
                }
            }
            else if(plan.equals("D")){
                x += 1;
                if(x < 0 || y < 0 || x > n-1 || y > n-1){
                    x -= 1;
                    continue;
                }
            }
        }
        System.out.print(x+1);
        System.out.print(" ");
        System.out.print(y+1);

    }
}
