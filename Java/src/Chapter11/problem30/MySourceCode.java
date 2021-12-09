package Chapter11.problem30;

import java.util.*;

public class MySourceCode {

    public static List<Integer> result = new ArrayList<>();
    public static Map<String, Integer> dic = new HashMap<>();

    public static void setDefault(){
        String Alphabet = "1ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 1; i < Alphabet.length(); i++){
            dic.put(Alphabet.substring(i,i+1), i);
        }

        System.out.println(dic.get("X"));
    }

    public static int[] solution(String msg) {

        setDefault();

        String w = msg.substring(0,1);

        for(int i = 1; i < msg.length(); i++){
            //다음 문자
            String c = msg.substring(i,i+1);
            //현재까지의 이어붙힌 문자가 사전에 없으면 전의 문자 출력 후 이어붙힌 문자 사전에 추가
            String wc = w + c;
            if(dic.get(wc) == null){
                result.add(dic.get(w));
                dic.put(wc, dic.size()+1);
                w = c;
            } else {
                w = wc;
            }
        }
        //나머지 문자 처리
        result.add(dic.get(w));

        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] answer = solution("KAKAO");

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
