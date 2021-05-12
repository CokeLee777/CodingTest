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
        //앞에서부터 슬라이싱
        for(int i = 0; i < input.length(); i++){
            String now = input.substring(i,i+1);
            //숫자이면 붙여넣는다
            if(!now.equals("+") && !now.equals("-")){
                sNum += now;
                continue;
            }
            //더하기 연산이면
            if(now.equals("+")){
                int iNum = Integer.parseInt(sNum);
                sNum = "";

            }
            //빼기 연산이면
            if(now.equals("-")){
                int iNum = Integer.parseInt(sNum);
                sNum = "";

            }
        }
    }
}
