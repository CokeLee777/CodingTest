package com.company;

import java.util.*;

public class Main {

    public static int[] arr = {7,5,9,0,3,1,6,2,4,8};
    public static ArrayList<Integer> list = new ArrayList<>();

    public static Map<String, Integer> map = new HashMap<>();

    public static final String[] numbers = {
            "zero","one","two","three","four","five","six","seven","eight","nine"
    };

    public static void beforeEach(){
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i);
        }
    }

    public static int solution(String s) {
        String answer = "";

        beforeEach();

        String englishNum = "";

        for(int i = 0; i < s.length(); i++){
            //영어가 아닌 숫자라면 무시하고 정답에 이어붙히고 전에 영어 숫자를 배열에서 찾음
            if(s.substring(i,i+1).charAt(0) - '0' < 10 && s.substring(i,i+1).charAt(0) - '0' >= 0){
                //빈 문자열이 아니라면
                if(!englishNum.equals("")){
                    Integer result = map.get(englishNum);
                    answer += result.toString();
                    englishNum = "";
                }

                answer += s.substring(i,i+1);
                continue;
            } else {

                englishNum += s.substring(i,i+1);

                //영어로 된 숫자가 연속으로 나오는것 처리
                Integer result = map.get(englishNum);
                if(result != null){
                    answer += result.toString();
                    englishNum = "";
                }


            }
        }

        if(!englishNum.equals("")){
            Integer result = map.get(englishNum);
            if(result != null){
                answer += result.toString();
            }
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int solution = solution("3sevensevensixsixzerozerozero5nine");

        System.out.println(solution);
    }
}
