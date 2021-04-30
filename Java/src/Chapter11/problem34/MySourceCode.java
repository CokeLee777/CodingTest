package Chapter11.problem34;

import java.io.IOException;
import java.util.*;

public class MySourceCode  {

    public static int n;
    public static int[] soldiers = new int[2000];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //병사의 수 입력
        n = sc.nextInt();

        //병사 입력받기
        for(int i = 0; i < n; i++){
            soldiers[i] = sc.nextInt();
        }

        //내림차순으로 다이나믹프로그래밍 수행
        int minValue = soldiers[n-1];
        int cnt = 0;
        for(int i = n-2; i >= 0; i--){
            //전투력이 더 낮으면 카운트 증가
            if(minValue > soldiers[i]){
                cnt += 1;
            } else {
                minValue = soldiers[i];
            }
        }

        System.out.println(cnt);
    }
}
