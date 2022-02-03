package algorithm.string;

public class PressString {

    public String mySourceCode(String str){
        //빈 문자열이라면
        if(str.length() == 0) return "";

        String answer = "";
        char temp = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            //전의 문자와 동일하다면
            if(str.charAt(i) == temp){
                count++;
            } else {
                answer += (count >= 2 ? temp + String.valueOf(count) : temp);
                temp = str.charAt(i);
                count = 1;
            }
        }

        return count >= 2 ? answer + temp + count : answer + temp;
    }
}
