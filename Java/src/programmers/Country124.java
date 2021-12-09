package programmers;

public class Country124 {

    public static String solution(int n) {
        String answer = "";

        Integer now = n;
        String result = "";

        //3으로 나눠서 3진법으로 치환
        while(now > 0){
            result = (now % 3) + result;
            now /= 3;
        }




        return answer;
    }

    public static void main(String[] args) {

    }
}
