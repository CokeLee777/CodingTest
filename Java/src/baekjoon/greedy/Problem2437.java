package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class Problem2437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //추의 개수 입력받기
        int n = Integer.parseInt(br.readLine());
        //각각의 추의 무게 입력받기
        int[] weight = new int[n];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            weight[i] = Integer.parseInt(input[i]);
        }

        //추를 무게가 작은 순서대로 정렬
        Arrays.sort(weight);

        //만약 무게추 중에 제일 작은게 1보다 크다면
        if(weight[0] > 1){
            bw.write(1 + "\n");
            bw.flush();
            return;
        }
        //무게를 잴 수 없을때까지 반복
        int sum = weight[0];
        for(int i = 1; i < n; i++){
            //더이상 무게를 잴 수 없다면
            if(sum+1 < weight[i]) break;
            //아니라면
            sum += weight[i];
        }

        bw.write((sum+1) + "\n");
        bw.flush();
    }
}
