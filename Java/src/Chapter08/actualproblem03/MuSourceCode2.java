package Chapter08.actualproblem03;

import java.util.*;

public class MuSourceCode2 {

    public static int n;
    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        d = new int[n];
        for(int i = 0; i < n; i++){
            d[i] = sc.nextInt();
        }
    }
}
