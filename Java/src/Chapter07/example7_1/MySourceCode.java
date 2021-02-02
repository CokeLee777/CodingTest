package Chapter07.example7_1;

import java.util.Scanner;

public class MySourceCode {

    public static int sequentialSearch(String[] arr, String target){

        for(int i = 0; i < arr.length; i++){
            //찾는 문자열이 있다면 인덱스 출력
            if(arr[i].equals(target)){
                return i;
            }
        }
        //찾는 문자열이 없다면 -1 출력
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //원소의 갯수 입력
        int n = sc.nextInt();
        //찾을 문자열 입력
        String target = sc.next();
        sc.nextLine();  //버퍼 비우기
        //문자열을 담을 공간
        String[] arr = sc.nextLine().split(" ");

        int result = sequentialSearch(arr, target);

        System.out.println("result = " + result);
    }
}
