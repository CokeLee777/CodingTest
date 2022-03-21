package baekjoon.dfsandbfs;

import java.io.*;
import java.util.PriorityQueue;

public class Problem7576 {

    static class Tomato implements Comparable<Tomato>{
        private int x;
        private int y;
        private int time;

        public Tomato(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getTime() {
            return time;
        }

        @Override
        public int compareTo(Tomato o) {
            return this.time - o.time;
        }
    }

    private static int row, col;
    private static int totalTomato, totalTime;
    private static int[][] box;

    private static final int[] dx = {0,0,1,-1};
    private static final int[] dy = {1,-1,0,0};

    private static PriorityQueue<Tomato> pq = new PriorityQueue();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //상자의 크기 입력받기
        String[] boxSize = br.readLine().split(" ");
        row = Integer.parseInt(boxSize[1]);
        col = Integer.parseInt(boxSize[0]);

        totalTomato = (row * col);

        //상자 입력받기
        box = new int[row][col];
        for(int i = 0; i < row; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < col; j++){
                int tomato = Integer.parseInt(input[j]);
                if(tomato == -1) totalTomato--;
                if(tomato == 1) pq.offer(new Tomato(i, j, 0));
                box[i][j] = tomato;
            }
        }

        //토마토 익히기 실행
        while(!pq.isEmpty()){
            Tomato tomato = pq.poll();
            int x = tomato.getX();
            int y = tomato.getY();
            int time = tomato.getTime();

            totalTomato--;
            totalTime = Math.max(time, totalTime);

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //벽이라면 무시
                if(nx < 0 || nx >= row || ny < 0 || ny >= col)
                    continue;
                //토마토가 없는 곳이라면 방문
                if(box[nx][ny] == 0){
                    pq.offer(new Tomato(nx, ny, time+1));
                    box[nx][ny] = 1;
                }
            }
        }

        if(totalTomato == 0) bw.write(totalTime + "\n");
        else bw.write(-1 + "\n");

        bw.flush();
    }
}
