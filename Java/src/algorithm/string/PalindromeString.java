package algorithm.string;

public class PalindromeString {

    public static String mySourceCode(String str){
        str = str.toLowerCase();
        char[] charArr = str.toCharArray();

        int left = 0, right = str.length()-1;
        while(left < right){
            if(charArr[left] != charArr[right]) return "NO";
            left++; right--;
        }
        return "YES";
    }
}
