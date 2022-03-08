package baekjoon.dfsandbfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem16946 {

    private static int row, col;
    private static int[][] graph;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static int bfs(int x, int y, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            cnt++;

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                //벽이거나 맵 밖이면 무시
                if(nx < 0 || nx >= row || ny < 0 || ny >= col || graph[nx][ny] == 1)
                    continue;
                if(!visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt % 10;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //행, 열의 개수 입력받기
        String[] input = br.readLine().split(" ");

        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);

        //그래프 입력받기
        graph = new int[row][col];
        for(int i = 0; i < row; i++){
            input = br.readLine().split("");
            for(int j = 0; j < col; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        //bfs 수행
        StringBuilder results = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(graph[i][j] == 1){
                    results.append(bfs(i, j, new boolean[row][col]));
                } else {
                    results.append("0");
                }
            }
            results.append("\n");
        }

        bw.write(results.toString());
        bw.flush();
    }
}
