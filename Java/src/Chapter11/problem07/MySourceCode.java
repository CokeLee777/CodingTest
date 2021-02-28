package Chapter11.problem07;

import java.util.*;

//럭키 스트레이트
public class MySourceCode {

    public static String[] n;
    public static int front, back;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //점수를 입력받음
        n = sc.nextLine().split("");
        //점수의 길이
        int length = n.length;
        //중간 인덱스
        int mid = length / 2;
        //반복문을 통한 앞 뒤 합을 구한다.
        for(int i = 0; i < mid; i++){
            front += (n[i].charAt(0) - '0');
        }
        for(int i = mid; i < length; i++){
            back += (n[i].charAt(0) - '0');
        }

        if(front == back) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
