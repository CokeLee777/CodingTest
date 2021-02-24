package Chapter11.problem02;

import java.util.*;

public class MySourceCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int result = 0;

        for(int i = 0; i < str.length(); i++){
            int now = str.charAt(i)- '0';
            if(now == 0){
                result += now;
            } else {
                if(result == 0){
                    result += now;
                } else {
                    result *= now;
                }
            }
        }

        System.out.println("result = " + result);
    }
}
