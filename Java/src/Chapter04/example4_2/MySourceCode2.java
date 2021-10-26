package Chapter04.example4_2;

import java.util.*;

public class MySourceCode2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        for(int h = 0; h <= n; h++){
            String hour = Integer.toString(h);
            for(int m = 0; m < 60; m++){
                String minute = Integer.toString(m);
                for(int s = 0; s < 60; s++){
                    String second = Integer.toString(s);
                    if(!hour.contains("3") && !minute.contains("3") && !second.contains("3")) continue;
                    else result += 1;
                }
            }
        }

        System.out.println("result = " + result);

    }
}
