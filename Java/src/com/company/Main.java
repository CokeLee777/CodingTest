package com.company;

import java.util.*;

//class Numbers implements Comparable<Numbers>{
//
//    private String number;
//
//    public Numbers(String number) {
//        this.number = number;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    @Override
//    public int compareTo(Numbers numbers) {
//        for(int i = 0; i < numbers.getNumber().length(); i++){
//        }
//    }
//}

public class Main {

    public static List<String> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 4;
        String number = "4177252841";


        //총 문자열의 길이
        int totalLength = number.length() - k;

        int prevIdx = 0;
        //총 문자열의 길이만큼 반복
        for(int i = 0; i < totalLength; i++){
            String prev = number.substring(prevIdx, totalLength);
            String sub = number.substring(totalLength--);
            //앞서 뽑은 문자열들 중 큰값을 반환
            for(int j = 0; j < prev.length(); j++){
                String now = prev.substring(j, j+1);

            }
        }
    }
}
