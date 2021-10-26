package Chapter03.actualproblem04;

import java.util.*;

public class MySourceCode2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();

        while(n != 1){
            if(n % k == 0) {
                n /= k;
                result += 1;
            } else {
                n -= 1;
                result += 1;
            }
        }

        System.out.println("result = " + result);
    }
}
