package com.company;

import java.util.*;

public class Main {

    public static String new_id = "abcdefghijklmn.p";

    public static String checkEmpty(String s){
        if(s.length() == 0){
            return "a";
        } else {
            return s;
        }
    }

    public static String checkDot(String s){
        s = checkEmpty(s);
        if(s.endsWith(".")){
            return s.substring(0, s.length()-1);
        }
        if(s.charAt(0) == '.'){
            return s.substring(1);
        }
        s = checkEmpty(s);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String answer = "";
        //소문자로 치환
        new_id = new_id.toLowerCase();
        //마침표 카운트
        int dotCount = 0;
        //소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        for(int i = 0; i < new_id.length(); i++){
            //현재 문자
            String nowStr = new_id.substring(i,i+1);
            //현재 문자의 숫자형
            int nowInt = nowStr.charAt(0) - '0';
            if(nowInt >= 0 && nowInt <= 9 ||
                    nowInt >= 49 && nowInt <= 74 ||
                    nowStr.equals("-") ||
                    nowStr.equals("_") ||
                    nowStr.equals(".")){
                //현재 문자열이 마침표가 아니라면
                if(!nowStr.equals(".")){
                    dotCount = 0;
                    answer += nowStr;
                    continue;
                }
                //현재 문자열이 마침표라면
                else {
                    dotCount += 1;
                    //마침표가 2번이상 연속된다면 무시
                    if(dotCount >= 2){
                        continue;
                    } else {
                        answer += nowStr;
                    }
                }

            } else {
                continue;
            }
        }

        //마침표가 처음이나 끝에 위치한다면 제거, 빈 문자열이면 "a"입력
        answer = checkDot(answer);
        //길이가 16자 이상이면 첫 15개를 제외하고 제거
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
        }
        //길이가 2자 이하면 마지막 문자를 길이가 3이 될때까지 붙힌다.
        answer = checkDot(answer);
        String last = answer.substring(answer.length() - 1);
        while(answer.length() <= 2){
            answer += last;
        }

        System.out.println(answer);
        System.out.println(("a".charAt(0) - '0') + " " + ("z".charAt(0) - '0'));

    }
}
