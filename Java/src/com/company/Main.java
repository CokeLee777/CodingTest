package com.company;

import java.util.*;

public class Main {

    public static String s = "abcabcabcabcdcc";  //4abcdcc

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "abcd";
        int i = s.compareTo("abcc");
        System.out.println("i = " + i);

//        int answer = s.length();
//        //1개단위부터 하나씩 늘려가며 확인
//        for(int step = 1; step < s.length(); step++){
//            String compressed = "";
//            String prev = s.substring(0, step); //앞에서부터 step 만큼 문자열 추출한다.
//            int cnt = 1;
//            //단위(step) 크기만큼 증가시키면서 문자열 비교
//            for(int j = step; j < s.length(); j += step){
//                //이전 문자열과 동일하다면 count 증가
//                String sub = "";
//                for(int k = j; k < j + step; k++){
//                    if(k < s.length()) sub += s.charAt(k);
//                }
//                if(prev.equals(sub)) cnt += 1;
//                //다른 문자열이 나왔다면 (더이상 압축 불가능 하다면)
//                else{
//                    //압축 수행
//                    compressed += (cnt >= 2) ? (cnt + prev) : prev;
//                    //다시 원래 상태로 복원
//                    sub = "";
//                    for(int k = j; k < j + step; k++){
//                        if(k < s.length()) sub += s.charAt(k);
//                    }
//                    prev = sub;
//                    cnt = 1;
//                }
//            }
//            //남아있는 문자열 처리
//            compressed += (cnt >= 2) ? (cnt + prev) : prev;
//            //가장 짧은것이 정답
//            answer = Math.min(answer, compressed.length());
//        }
//
//        System.out.println("answer = " + answer);
    }
}
