package algorithm.string;

public class SearchCharacter {

    public static int mySourceCode(String input1, String input2){
        int[] nums = new int[26];
        String s1 = input1.toLowerCase();
        String s2 = input2.toLowerCase();

        for(int i = 0; i < s1.length(); i++){
            nums[s1.charAt(i) - 'a']++;
        }

        return nums[s2.charAt(0) - 'a'];
    }
    //솔루션1
    public static int solution1(String str, char c){
        int answer = 0;
        //모두 대문자로 변경
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c) answer++;
        }

        return answer;
    }
    //솔루션2
    public static int solution2(String str, char c){
        int answer = 0;
        //모두 대문자로 변경
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for(char x: str.toCharArray()){
            if(x == c) answer++;
        }

        return answer;
    }
}
