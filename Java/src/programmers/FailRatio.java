package programmers;

import java.util.*;

public class FailRatio {

    public static int solution(int n) {
        int answer = 0;
        String third = "";

        while(n != 0){
            third += n % 3;
            n /= 3;
        }

        int now = 1;

        for(int i = third.length()-1; i >= 0; i--){
            answer += Integer.parseInt(third.substring(i, i+1)) * now;
            now *= 3;
        }

        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(45);
        System.out.println(answer);
    }
}
