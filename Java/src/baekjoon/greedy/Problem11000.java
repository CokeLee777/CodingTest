package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //강의실의 개수 입력받기
        int n = Integer.parseInt(br.readLine());

        //n개의 수업 입력받기
        int[][] course = new int[n][2];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");

            course[i][0] = Integer.parseInt(input[0]);
            course[i][1] = Integer.parseInt(input[1]);
        }

        //강의 시작시간을 기준으로 오름차순 정렬
        Arrays.sort(course, Comparator.comparingInt(c -> c[0]));

        //강의 종료시마다 종료시간을 큐에 삽입하여 비교
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(0);

        for(int i = 0; i < n; i++){
            int start = course[i][0];
            int end = course[i][1];
            //강의실을 더 안빌려도 된다면
            if(endTimes.peek() <= start){
                endTimes.poll();
                endTimes.offer(end);
            }//강의실을 빌려야 한다면
            else {
                endTimes.offer(end);
            }
        }

        int room = endTimes.size();

        bw.write(room + "\n");
        bw.flush();
    }
}
