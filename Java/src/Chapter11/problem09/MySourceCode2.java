package Chapter11.problem09;

import java.util.*;

public class MySourceCode2 {

    public static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.nextLine();

        String prevCompressed = s;
        //단위별로 반복문 돌리기(1,2 개단위 등)
        for(int unit = 1; unit < s.length(); unit++){
            Integer count = 1;      //겹치는 횟수
            String prev = s.substring(0, unit);   //이전 문자
            String compressed = "";
            for(int i = unit; i < s.length(); i += unit){

                String sub = "";

                //단위 만큼의 문자열이 문자열의 길이를 넘지 않는다면 현재 문자열에 담기
                if(i+unit < s.length()) sub = s.substring(i, i+unit);
                //아니라면 나머지 추가
                else sub = s.substring(i);

                //이전 문자열과 동일하다면 카운트 증가
                if(sub.equals(prev)){
                    count++;
                    prev = sub;
                }
                //아니라면 문자열 이어 붙이기
                else {
                    //카운트가 1이라면 숫자 빼고 이어 붙이기
                    compressed += count > 1 ? ((count.toString()) + prev) : prev;

                    prev = sub;
                    count = 1;
                }
            }

            //남은 문자열 처리
            //카운트가 1이라면 숫자 빼고 이어 붙이기
            compressed += count > 1 ? ((count.toString()) + prev) : prev;

            //지금 단위로 압축된 문자가 전에 압축된 문자보다 길이가 작다면
            if(compressed.length() < prevCompressed.length()){
                prevCompressed = compressed;
            }
        }

        System.out.println(prevCompressed.length());
    }
}
