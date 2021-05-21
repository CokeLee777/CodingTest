package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "cdcd";

        while(true){
            String compressed = "";
            for(int i = 1; i < s.length(); i++){
                String prev = s.substring(i-1,i);
                String sub = s.substring(i, i+1);
                //앞뒤 문자열이 같다면 압축 - 사라짐
                if(prev.equals(sub)){
                    compressed += s.substring(i+1);
                    break;
                }
                //아니면 문자열 그대로 반환
                else{
                    if(i == s.length()-1) compressed += prev + sub;
                    else compressed += prev;
                }
            }
            //압축할 것이 없고 그대로 출력된다면 0 반환 후 종료
            if(s.equals(compressed)){
                System.out.println(0);
                break;
            }
            //아니면 압축 후 다시수행
            s = compressed;
            //빈 문자열까지 압축했다면 1 반환 후 종료
            if(s.equals("")){
                System.out.println(1);
                break;
            }
        }
    }
}
