package Chapter08.actualproblem03;

import java.util.*;

public class MySourceCode3 {

    public static int[] d;
    public static int[] stores;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        d = new int[n];
        stores = new int[n];
        for(int i = 0; i < n; i++){
            stores[i] = sc.nextInt();
        }

        d[0] = stores[0];
        d[1] = Math.max(stores[0], stores[1]);
        d[2] = Math.max(d[1], d[0] + stores[2]);

        for(int i = 3; i < n; i++){
            d[i] = Math.max(d[i-1], d[i-2] + stores[i]);
        }

        System.out.println(d[n-1]);
    }
}
