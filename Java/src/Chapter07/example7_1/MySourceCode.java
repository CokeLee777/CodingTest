package Chapter07.example7_1;

import java.util.Scanner;

public class MySourceCode {

    public static int sequential_search(int n, String target, String[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(target)) return i;
        }
        //찾는 문자열이 없다면
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //생성할 원소 개수 입력
        int n = sc.nextInt();
        //찾을 문자열 입력
        String target = sc.next();
        sc.nextLine();  //버퍼 비우기
        //앞서 적은 원소 갯수만큼 문자열 입력
        String[] arr = sc.nextLine().split(" ");

        System.out.println(sequential_search(n, target, arr));

    }
}
