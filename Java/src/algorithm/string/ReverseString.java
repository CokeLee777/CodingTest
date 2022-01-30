package algorithm.string;

import java.util.ArrayList;

public class ReverseString {

    public static String[] mySourceCode(String[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        }
        return arr;
    }

    public static ArrayList<String> solution1(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] cArr = x.toCharArray();

            int left = 0, right = cArr.length-1;
            while(left < right){
                char temp = cArr[left];
                cArr[left] = cArr[right];
                cArr[right] = temp;
                left++; right--;
            }

            String s = String.valueOf(cArr);
            answer.add(s);
        }

        return answer;
    }
}
