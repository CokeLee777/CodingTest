package Chapter11.problem09;

import java.util.*;

public class Solution {

    public static String inputStr;

    public static int solution(String s) {
        //먼저 처음 문자열의 길이를 삽입한다
        int answer = s.length();
        //1개 단위부터 압축 단위를 늘려가며 확인한다.
        for(int step = 1; step < s.length(); step++){
            String compressed = "";             //압축된 문자열
            String prev = s.substring(0, step); //앞에서부터 step만큼의 문자열 추출
            int cnt = 1;
            //단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for(int j = step; j < s.length(); j += step){
                //다음 step 만큼의 문자열이 이전 상태와 동일하다면 압축 횟수(count) 증가
                String sub = "";
//                for(int k = j; k < j + step; k++){
//                    //원래 문자열의 길이를 넘지 않는 선에서 문자열을 더한다
//                    if(k < s.length()) sub += s.charAt(k);
//                }
                //원래 문자열의 길이를 넘지 않는 선에서 문자열을 더한다.
                if(j + step < s.length()) sub = s.substring(j, j+step);
                else sub = s.substring(j);

                if(prev.equals(sub)) cnt += 1;
                //다른 문자열이 나왔다면(더 이상 압축하지 X)
                else{
                    //같은 문자열이 2번이상 중복되었다면 앞에 중복된 횟수를 넣고 문자열 삽입
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    for(int k = j; k < j + step; k++){
                        if(k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; //다시 상태 초기화
                    cnt = 1;
                }
            }
            //나머지 문자열 처리
            compressed += (cnt >= 2) ? cnt + prev : prev;
            //만들어지는 압축 문자열이 가장 짧은 것이 정답이다
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        inputStr = sc.next();

        int result = solution(inputStr);

        System.out.println(result);
    }
}
