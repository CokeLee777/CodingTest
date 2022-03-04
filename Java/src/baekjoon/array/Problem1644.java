package baekjoon.array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem1644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //자연수 N 입력받기
        int N = Integer.parseInt(br.readLine());

        //2또는 3이라면
        if(N == 2 || N == 3) {
            bw.write(1 + "\n");
            bw.flush();
            return;
        }

        //N까지의 소수 찾기
        List<Integer> nums = findNums(N);

        //연속된 소수의 합으로 나타낼 수 있는지 확인
        int leftIdx = 0;
        int sum = 0; int cnt = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
            //합이 더 크다면
            while(sum - nums.get(leftIdx) >= N){
                sum -= nums.get(leftIdx++);
            }
            //합이 타겟과 동일하다면
            if(sum == N) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
    //에라토스테네스의 체 알고리즘
    private static List<Integer> findNums(int N){
        boolean[] prime = new boolean[N+1];
        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;

        for(int i=2; i*i<=N; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<=N; j+=i) {
                    prime[j] = true;
                }
            }
        }

        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < prime.length; i++){
            if(!prime[i]) nums.add(i);
        }

        return nums;
    }
}
