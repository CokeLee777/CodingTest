package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class problem1931 {

    private static int n;
    private static int[][] conference;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //회의의 수 입력받기
        n = Integer.parseInt(br.readLine());
        //각 회의 입력받기
        conference = new int[n][2];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");

            conference[i][0] = Integer.parseInt(input[0]);
            conference[i][1] = Integer.parseInt(input[1]);
        }

        //종료시간을 기준으로 오름차순 정렬
        Arrays.sort(conference, (o1, o2) -> {
            if(o1[1] < o2[1]) return -1;
            //종료시간이 같으면 시작시간이 빠른 순서대로 정렬
            else if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return 1;
        });

        //회의의 최대개수 찾기
        int max = 0;
        int endTime = 0;
        for(int i = 0; i < n; i++){
            if(endTime <= conference[i][0]){
                endTime = conference[i][1];
                max++;
            }
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
