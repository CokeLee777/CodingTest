package Chapter11.problem01;

import java.util.*;

public class MySourceCode {

    public static int n;
    public static Integer[] arr = new Integer[100001];
    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //모험가의 수 입력받기
        n = sc.nextInt();
        Arrays.fill(arr, 0);
        //모험가의 각 공포도 값 입력받기
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        //공포도 내림차순으로 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        int now = 0;

        while(arr[now] != 0){
            result += 1;
            now += arr[now];
        }

        System.out.println(result);
    }
}
