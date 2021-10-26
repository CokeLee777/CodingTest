package baekjoon.greedy;

import java.util.*;

//수정중
public class problem1541 {

    public static String input;
    public static List<Integer> num = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = sc.nextLine();

        int result = 0;
        String sNum = "";
        boolean sub = false;
        //앞에서부터 슬라이싱
        for(int i = 0; i < input.length(); i++){
            String now = input.substring(i,i+1);
            //숫자이면 붙여넣는다
            if(!now.equals("+") && !now.equals("-")){
                sNum += now;
                continue;
            }
            //빼기 연산이면서 전에 연산자도 빼기 였을 경우
            if(now.equals("-") && sub){
                int iNum = Integer.parseInt(sNum);
                result -= iNum;
                sNum = "";
                sub = false;
            }
            //빼기 연산이고 전에 연산자는 더하기 였을 경우
            else if(now.equals("-") && !sub){
                int iNum = Integer.parseInt(sNum);
                result +=  iNum;
                sNum = "";
                sub = true;
            }
        }
        System.out.println("result = " + result);
    }
}
