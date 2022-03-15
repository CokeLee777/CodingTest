package baekjoon.divideandconquer;

import java.io.*;

public class Problem1074 {

    private static int count;

    public static void find(int size, int r, int c) {
        if(size == 1)
            return;
        //2사분면에 속한다면
        if(r < size/2 && c < size/2) {
            find(size/2, r, c);
        }
        //1사분면에 속한다면
        else if(r < size/2 && c >= size/2) {
            count += size * size / 4;
            find(size/2, r, c - size/2);
        }
        //3사분면에 속한다면
        else if(r >= size/2 && c < size/2) {
            count += (size * size / 4) * 2;
            find(size/2, r - size/2, c);
        }
        //4사분면에 속한다면
        else {
            count += (size * size / 4) * 3;
            find(size/2, r - size/2, c - size/2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //n과 목표 행, 열 r,c 입력받기
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int size = (int) Math.pow(2, n);

        find(size, r, c);

        bw.write(count + "\n");
        bw.flush();
    }
}
