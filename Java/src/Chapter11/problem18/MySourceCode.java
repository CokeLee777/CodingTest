package Chapter11.problem18;

import java.util.*;

/**
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 *   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 *   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 *   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 *   4-3. ')'를 다시 붙입니다.
 *   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 *   4-5. 생성된 문자열을 반환합니다.
 */
public class MySourceCode {

    public static String answer = "";

    public static String solution(String p) {

        String split = split(p);


        return split;
    }

    public static String split(String p) {

        //입력이 빈 문자열이면 빈 문자열 반환
        if(p.equals("")) return "";

        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < p.length(); i++){
            String type = p.substring(i,i+1);

            boolean check;

            if(type.equals("(")) {
                leftCount += 1;
                check = false;
            }
            else {
                rightCount += 1;
                check = true;
            }

            //균형잡힌 문자열로 분리
            if(leftCount == rightCount) {
                String u = p.substring(0,i+1);
                String v = p.substring(i+1);

                //올바른 괄호 문자열이라면
                if(check) return u + split(v);
                //올바른 괄호 문자열이 아니지만 균형잡힌 문자열이라면
                else {
                    String s = "(";
                    s += split(v);
                    s += ")";
                    String rest = u.substring(1,u.length()-1);
                    rest = rest.replaceAll("\\(", "0");
                    rest = rest.replaceAll("\\)", "(");
                    rest = rest.replaceAll("[0-9]", ")");
                    s += rest;
                    return s;
                }
            }

        }

        return p;
    }

    public static void main(String[] args) {

        String answer = solution("()))((()");

        System.out.println("answer = " + answer);
    }
}
