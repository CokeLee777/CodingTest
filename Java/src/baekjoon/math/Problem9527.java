package baekjoon.math;

import java.io.*;

public class Problem9527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        long start = Long.parseLong(input[0]);
        long end = Long.parseLong(input[1]);

        //이진수로 변환 후 1의 개수 카운팅
        long sum = 0;
        for(long i = start; i <= end; i++){
            long num = i;

            while(num > 0){
                sum += (num % 2);
                num /= 2;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}
