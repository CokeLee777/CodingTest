package Chapter08.actualproblem02;

import java.util.*;

public class MySourceCode {

    public static int[] arr = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //정수 x 를 입력받는다.
        int x = sc.nextInt();

        for(int i = 2; i <= x; i++){
            //현재 값에서 1을 먼저 뺐을때 값
            arr[i] = arr[i-1] + 1;
            //5로 나누어 떨어지면
            if(i % 5 == 0){
                arr[i] = Math.min(arr[i], arr[i / 5] + 1);
                continue;
            }
            //3으로 나누어 떨어지면
            if(i % 3 == 0){
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
                continue;
            }
            //2로 나누어 떨어지면
            if(i % 2 == 0){
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }
        }

        System.out.println("result = " + arr[x]);
    }

}