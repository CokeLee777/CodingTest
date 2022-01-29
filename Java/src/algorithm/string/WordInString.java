package algorithm.string;

public class WordInString {

    public static String mySourceCode(String str){
        String answer = "";
        String[] splits = str.split(" ");

        for(String s: splits){
            if(s.length() > answer.length()) answer = s;
        }

        return answer;
    }

    public static String solution1(String str){
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){
            int len = x.length();
            if(len > m){
                m = len;
                answer = x;
            }
        }
        return answer;
    }

    public static String solution2(String str){
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos = str.indexOf(" ")) != -1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m){
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m) answer = str;
        return answer;
    }
}
