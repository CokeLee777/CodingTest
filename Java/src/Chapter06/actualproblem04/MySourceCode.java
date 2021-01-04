package Chapter06.actualproblem04;

import java.util.*;

public class MySourceCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arrA = new Integer[n];
        Integer[] arrB = new Integer[n];

        for(int i = 0; i < n; i++){
            arrA[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            arrB[i] = sc.nextInt();
        }

        //두 배열 정렬 (바꿔치기 위해 B배열은 내림차순으로 정렬)
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());

        //바꿔치지 연산 수행
        for(int i = 0; i < k; i++){
            if(arrA[i] < arrB[i]){
                int temp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = temp;
            }
        }

        int sum = 0;
        for(Integer data: arrA){
            sum += data;
        }
        System.out.println(sum);
    }

}
