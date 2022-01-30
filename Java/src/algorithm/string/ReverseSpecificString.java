package algorithm.string;

public class ReverseSpecificString {

    public static String mySourceCode(String str){
        char[] charArray = str.toCharArray();

        int left = 0, right = charArray.length-1;
        while(left < right){
            if(!Character.isAlphabetic(charArray[left])) {
                left++;
                continue;
            }
            if(!Character.isAlphabetic(charArray[right])) {
                right--;
                continue;
            }
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++; right--;
        }

        return String.valueOf(charArray);
    }
}
