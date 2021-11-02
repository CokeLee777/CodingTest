package Chapter08.actualproblem04;

import java.util.*;

public class MySourceCode2 {

    public static int n;
    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        d = new int[n+1];
        d[1] = 1;
        d[2] = 3;

        for(int i = 3; i <= n; i++){
            d[i] = (d[i-1] + 2*d[i-2]) % 796796;
        }
    }
}
