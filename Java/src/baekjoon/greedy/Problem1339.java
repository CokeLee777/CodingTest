package baekjoon.greedy;

import java.io.*;
import java.util.Map;

public class Problem1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //단어의 개수 입력받기
        int n = Integer.parseInt(br.readLine());
        //단어 입력받기
        String[] words = new String[n];

        for(int i = 0; i < n; i++){
            words[i] = br.readLine();
        }

    }
}
