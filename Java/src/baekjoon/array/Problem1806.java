package baekjoon.array;

import java.io.*;

public class Problem1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //수열의 길이와 타겟 입력받기
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        //수열의 원소들 입력받기
        input = br.readLine().split(" ");

        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        //최소길이 구하기
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for(int i = 0; i < N; i++){
            sum += nums[i];
            //만약 현재 합이 S보다 크거나 같다면
            if(sum >= S){
                while(sum - nums[left] >= S){
                    sum -= nums[left++];
                }
                min = Math.min(i - left + 1, min);
            }
        }

        if(min == Integer.MAX_VALUE) bw.write(0 + "\n");
        else bw.write(min + "\n");

        bw.flush();
    }
}
