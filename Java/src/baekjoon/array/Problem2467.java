package baekjoon.array;

import java.io.*;

public class Problem2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //용액의 개수 입력받기
        int N = Integer.parseInt(br.readLine());
        //용액들 입력받기
        int[] nums = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        //0에 가장 가까운 용액 추출
        int left = 0, right = N-1;
        long min = Long.MAX_VALUE;

        long[] ans = new long[]{nums[0], nums[N-1]};
        while(left < right){
            //최소값 추출
            long now = nums[left] + nums[right];
            if(Math.abs(now) < min){
                min = Math.abs(now);
                ans[0] = nums[left]; ans[1] = nums[right];
            }
            //다음 비교값
            if(left+1 <= right && left <= right-1){
                long next1 = nums[left+1] + nums[right];
                long next2 = nums[left] + nums[right-1];
                if(Math.abs(next1) > Math.abs(next2)) right--;
                else left++;
            }
        }

        bw.write(ans[0] + " " + ans[1] + "\n");
        bw.flush();
    }
}
