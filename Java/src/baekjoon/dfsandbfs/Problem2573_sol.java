package baekjoon.dfsandbfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2573_sol {

    private static int row, col;
    private static int[][] graph;

    private static final int[] dx = {0,0,1,-1};
    private static final int[] dy = {1,-1,0,0};

    static class IceBerg{
        private int x;
        private int y;

        public IceBerg(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static int separatedNum(){
        boolean[][] visited = new boolean[row][col];

        int cnt = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(graph[i][j] != 0 && !visited[i][j]){
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int x, int y, boolean[][] visited){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //벽이라면 무시
            if(nx < 0 || nx >= row || ny < 0 || ny >= col)
                continue;
            if(!visited[nx][ny] && graph[nx][ny] != 0){
                dfs(nx, ny, visited);
            }
        }
    }

    public static void melt(){
        //현재 남은 빙산들 큐에 삽입후 방문처리
        Queue<IceBerg> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(graph[i][j] != 0){
                    queue.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            IceBerg iceBerg = queue.poll();
            int x = iceBerg.getX();
            int y = iceBerg.getY();

            //네 방향 확인
            int meltCnt = 0;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //벽이라면 무시
                if(nx < 0 || nx >= row || ny < 0 || ny >= col)
                    continue;
                //방문하지 않고 물이라면 증가
                if(!visited[nx][ny] && graph[nx][ny] == 0) meltCnt++;
            }

            if(graph[x][y] - meltCnt < 0) graph[x][y] = 0;
            else graph[x][y] -= meltCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //행, 열 입력받기
        String[] input = br.readLine().split(" ");

        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);

        //그래프 초기화
        graph = new int[row][col];
        for(int i = 0; i < row; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < col; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        int time = 0;
        //분리된 빙산이 2개이상이 될때까지 반복
        while((cnt = separatedNum()) < 2){
            //빙산이 모두 없어졌다면 0 반환
            if(cnt == 0){
                time = 0;
                break;
            }
            //빙산을 녹인 뒤 시간 증가
            melt();
            time++;
        }

        bw.write(time + "\n");
        bw.flush();
    }
}
