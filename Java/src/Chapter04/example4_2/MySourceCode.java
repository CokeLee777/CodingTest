package Chapter04.example4_2;

import java.util.*;

public class MySourceCode {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //시각을 입력받는다.
        int n = sc.nextInt();

        int result = 0;
        for(Integer h = 0; h <= n; h++){
            String sh = h.toString();
            for(Integer m = 0; m < 60; m++){
                String sm = m.toString();
                for(Integer s = 0; s < 60; s++){
                    String ss = s.toString();
                    //3이 하나라도 포함되면 횟수 증가
                    if(sh.contains("3") || sm.contains("3") || ss.contains("3")) result++;
                }
            }
        }

        System.out.println("result = " + result);
    }
}
