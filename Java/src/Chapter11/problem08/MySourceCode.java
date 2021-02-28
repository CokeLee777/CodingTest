package Chapter11.problem08;

import java.util.*;

public class MySourceCode {

    public static String[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        arr = sc.nextLine().split("");

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            int now = arr[i].charAt(0) - '0';

            if(now < 17) sum += now;
            else System.out.print(arr[i]);
        }

        System.out.print(sum);

    }
}
