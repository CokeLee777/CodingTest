package algorithm.string;

public class RevertUpperLower {
    public static String mySourceCode(String str){
        String answer = "";

        for(char x: str.toCharArray()){
            if(Character.isUpperCase(x)){
                answer += Character.toLowerCase(x);
            } else {
                answer += Character.toUpperCase(x);
            }
        }

        return answer;
    }

    public static String solution1(String str){
        String answer = "";
        for(char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) answer += Character.toUpperCase(x);
            else answer += Character.toLowerCase(x);
        }
        return answer;
    }

    /**
     * ASCII NUMBER
     * 대문자: 65(A)~90(Z)
     * 소문자: 97(a)~122(z)
     */
    public static String solution2(String str){
        String answer = "";
        for(char x : str.toCharArray()) {
            //소문자라면
            if(x >= 97 && x <= 122) answer += (char)(x - 32);
            else answer += (char)(x + 32);
        }
        return answer;
    }
}
