package baekjoon.String;

import java.io.*;

public class Problem16916 {

    public static boolean isSubsequence(int[] nums){
        for(int i = 0; i < 26; i++){
            if(nums[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //p가 s의 부분 문자열인지 비교
        String s = br.readLine();
        String p = br.readLine();

        if(s.length() < p.length()){
            bw.write(0 + "\n");
            bw.flush();
            return;
        }

        //p의 모든 원소의 개수 배열에 삽입
        int[] nums = new int[26];
        for(int i = 0; i < p.length(); i++){
            nums[p.charAt(i) - 'a']++;
        }

        //s와 p비교
        int len = p.length();
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            nums[s.charAt(i) - 'a']--;
            //p의 길이만큼 갔다면
            if(i >= len-1) {
                //부분수열인지 아닌지 비교
                if(isSubsequence(nums) && p.equals(s.substring(i-len+1, i+1))){
                    ans = 1;
                    break;
                }
                nums[s.charAt(i - len + 1) - 'a']++;

            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
