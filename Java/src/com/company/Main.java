package com.company;

import java.util.*;

public class Main {

    public static String new_id = "abcdefghijklmn.p";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String answer = "";

        //모든 대문자를 소문자로 변환
        new_id = new_id.toLowerCase();

        //마침표 카운트
        int dotCount = 0;
        //반복문을 돌려가면서 앞에서부터 확인
        for(int i = 0; i < new_id.length(); i++){
            //현재 문자
            String now = new_id.substring(i,i+1);
            //현재 문자의 숫자 변환버젼
            int Inow = now.charAt(0) - '0';
            //알파벳이면 추가
            if(Inow >= 49 && Inow <= 74){
                answer += now;
                continue;
            }
            //숫자면 추가
            if(Inow >= 0 && Inow < 10){
                answer += now;
                continue;
            }
            //숫자나 빼기 밑줄 이 나온다면
            if(now.equals("-") || now.equals("_")){
                answer += now;
                continue;
            }
            //빈 문자열 이라면
            if(now.equals(" ")) answer += "a";

            //첫번째 위치, 끝 위치일 때 마침표가 나오면
            if(answer.equals("") || i == new_id.length() - 1){
                //마침표가 나온다면 무시
                if(new_id.charAt(i) == '.') continue;
            }
            //마침표가 나온다면
            if(now.equals(".")){
                //마침표가 2번이상 나오지 않았다면
                if(dotCount < 1){
                    answer += now;
                    dotCount += 1;
                } else {
                    dotCount = 0;
                }
            }


        }

        //길이가 16자 이상이면
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            //끝에 마침표가 존재한다면 제거
            if(answer.charAt(14) == '.'){
                answer = answer.substring(0, 14);
            }
        }
        //길이가 2자 이하라면
        if(answer.length() <= 2){
            while(answer.length() < 3){
                answer += answer.substring(answer.length() - 1);
            }
        }


        System.out.println(answer);


    }
}
