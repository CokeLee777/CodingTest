package baekjoon.binarysearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem2143 {

    private static List<Long> left = new ArrayList<>();
    private static List<Long> right = new ArrayList<>();

    private static void getSubsequence(int[] nums, List<Long> results){
        for(int i = 0; i < nums.length; i++){
            long sum = nums[i];
            results.add(sum);
            for(int j = i+1; j < nums.length; j++){
                results.add(sum += nums[j]);
            }
        }
    }

    private static long getCount(int target){
        int aIdx = 0;
        int bIdx = 0;
        long cnt = 0;

        while(aIdx < left.size() && bIdx < right.size()){
            long sum = left.get(aIdx) + right.get(bIdx);
            //타겟과 일치한다면
            if(sum == target){
                //A의 부분수열 같은것 조합 더하기
                long a = left.get(aIdx);
                long cnt1 = 0;
                while(aIdx < left.size() && left.get(aIdx) == a){
                    aIdx++;
                    cnt1++;
                }
                //B의 부분수열 같은것 조합 더하기
                long b = right.get(bIdx);
                long cnt2 = 0;
                while(bIdx < right.size() && right.get(bIdx) == b){
                    bIdx++;
                    cnt2++;
                }

                cnt += (cnt1 * cnt2);
            } else if (sum < target){
                aIdx++;
            } else {
                bIdx++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //타겟 입력받기
        int target = Integer.parseInt(br.readLine());
        //A배열의 길이와 원소 입력받기
        int n = Integer.parseInt(br.readLine());
        String[] aValues = br.readLine().split(" ");
        int[] A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(aValues[i]);
        }
        //B배열의 길이와 원소 입력받기
        int m = Integer.parseInt(br.readLine());
        String[] bValues = br.readLine().split(" ");
        int[] B = new int[m];
        for(int i = 0; i < m; i++){
            B[i] = Integer.parseInt(bValues[i]);
        }

        //A배열의 부분수열과 B배열의 부분수열 각각 구하기
        getSubsequence(A, left);
        getSubsequence(B, right);

        //각각의 부분수열의 합 정렬
        Collections.sort(left);
        Collections.sort(right, Collections.reverseOrder());

        long cnt = getCount(target);

        bw.write(cnt + "\n");
        bw.flush();
    }
}
