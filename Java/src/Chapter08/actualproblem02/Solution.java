package Chapter08.actualproblem02;

import java.util.*;

public class Solution {
    public static int[] arr = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        for(int i = 2; i < x + 1; i++){

            //x에서 1을 빼는 경우
            arr[i] = arr[i - 1] + 1;

            //x가 5로 나누어 떨어지면
            if(i % 5 == 0){
                arr[i] = Math.min(arr[i], arr[i / 5] + 1);
                continue;
            }
            //x가 3으로 나누어 떨어지면
            if(i % 3 == 0){
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
                continue;
            }
            //x가 2로 나누어 떨어지면
            if(i % 2 == 0){
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }

        }

        System.out.println(arr[x]);

    }
}
