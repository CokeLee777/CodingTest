package baekjoon.binarysearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1208 {

    private static long[] nums;
    private static List<Long> left = new ArrayList<>();
    private static List<Long> right = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //정수의 개수와 타겟 입력받기
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);

        //정수 입력받기
        nums = new long[n];

        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        //반으로 나눠서 부분수열 구하기 -> 왼쪽과 오른쪽으로 분할
        getSubsequence(nums, 0, n/2, 0, left);
        getSubsequence(nums, n/2,n,  0, right);

        //부분수열 둘 다 정렬
        Collections.sort(left);
        Collections.sort(right);

        long cnt = getCount(target);

        //타겟이 0이라면 1을 뺀다 -> 조합중 0,0조합이 무조건 존재하기 때문이다
        if(target == 0) cnt--;

        bw.write(cnt + "\n");
        bw.flush();
    }

    // 부분수열의 합을 구하는 재귀함수
    private static void getSubsequence(long[] nums, int start, int end, long sum, List<Long> results){

        if(start==end){
            results.add(sum);
            return;
        }

        getSubsequence(nums, start+1, end, sum+nums[start], results);
        getSubsequence(nums, start+1, end, sum, results);
    }

    //왼쪽 오른쪽의 부분수열에서 조합의 개수를 구하는 함수
    private static long getCount(int target){
        int leftIdx = 0;
        int rightIdx = right.size()-1;
        long cnt = 0;
        //배열의 요소가 끝날때까지 반
        while(leftIdx < left.size() && rightIdx >= 0){
            //현재 합
            long sum = left.get(leftIdx) + right.get(rightIdx);
            //현재 합이 타겟이랑 동일하다면
            if(sum == target){
                //왼쪽값이랑 동일한 부분수열이 몇개있는지 추출
                long a = left.get(leftIdx);
                long cnt1 = 0;
                while(leftIdx < left.size() && left.get(leftIdx) == a){
                    leftIdx++;
                    cnt1++;
                }
                //오른쪽값이랑 동일한 부분수열이 몇개있는지 추출
                long b = right.get(rightIdx);
                long cnt2 = 0;
                while(rightIdx >= 0 && right.get(rightIdx) == b){
                    rightIdx--;
                    cnt2++;
                }
                //총 조합의 개수를 추가
                cnt += (cnt1 * cnt2);
            } else if (sum < target){
                leftIdx++;
            } else {
                rightIdx--;
            }
        }

        return cnt;
    }
}
