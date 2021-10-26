package Chapter03.actualproblem03;

import java.util.*;

public class MySourceCode {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int maxOfArr = 0;

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++){
            int minOfRow = 10001;
            for(int j = 0; j < m; j++){
                minOfRow = Math.min(minOfRow, sc.nextInt());
            }
            maxOfArr = Math.max(maxOfArr, minOfRow);
        }

        System.out.println("maxOfArr = " + maxOfArr);

    }
}
