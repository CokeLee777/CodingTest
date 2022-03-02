package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10942 {

    private static boolean isPalindrome(int[] nums, int left, int right){
        while(left < right){
            if(nums[left] != nums[right]) return false;
            left++; right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //수열의 크기
        int n = Integer.parseInt(br.readLine());
        //칠판에 n개의 수를 적는다
        int[] nums = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        //질문의 개수를 입력받고 질문을 받는다
        int m = Integer.parseInt(br.readLine());
        StringBuilder results = new StringBuilder();
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());

            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            //팰린드롬의 여부 구하기
            if(isPalindrome(nums, startIdx, endIdx)) results.append("1\n");
            else results.append("0\n");
        }

        System.out.println(results);
    }
}
