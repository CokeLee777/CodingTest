package Chapter11.problem03;

import java.util.*;

public class MySourceCode {

    public static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int count0 = 0;
        int count1 = 0;

        s = sc.nextLine();

        if(s.charAt(0) == '0'){
            count0 += 1;
        } else {
            count1 += 1;
        }

        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                //1로 바뀌는 경우
                if(s.charAt(i+1) == '1') count1 += 1;
                else count0 += 1;
            }
        }

        result = Math.min(count0, count1);
        System.out.println("result = " + result);
    }
}
