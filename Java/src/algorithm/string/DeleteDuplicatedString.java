package algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicatedString {

    public static String mySourceCode(String str){
        String answer = "";
        List<Character> results = new ArrayList<>();

        for(char x : str.toCharArray()){
            if(!results.contains(x)){
                answer += x;
                results.add(x);
            }
        }
        return answer;
    }
}
