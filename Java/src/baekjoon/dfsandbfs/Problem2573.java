package baekjoon.dfsandbfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2573 {

    private static int row, col;
    private static int[][] graph;
    private static int time, islandNum, visitedNum;

    private static final int[] dx = {0,0,1,-1};
    private static final int[] dy = {1,-1,0,0};

    public static void dfs(int x, int y, boolean[][] visited){
        //현재 빙산 방문처리
        visited[x][y] = true;
        visitedNum++;

        int meltCnt = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //벽이면 무시
            if(nx < 0 || nx >= row || ny < 0 || ny >= col)
                continue;
            //방문한적이 없고 물이라면
            if(!visited[nx][ny] && graph[nx][ny] == 0) {
                meltCnt++;
                continue;
            }
            //방문한적이 없고 물이 아니라면
            if(!visited[nx][ny] && graph[nx][ny] != 0){
                dfs(nx, ny, visited);
            }
        }

        //현재 빙산 녹이기
        graph[x][y] = Math.max(graph[x][y] - meltCnt, 0);
        //현재 빙산이 다 녹았다면 전체 빙산의 개수와 현재 방문한 빙산의 개수 감소
        if(graph[x][y] == 0) {
            islandNum--;
            visitedNum--;
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
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < col; j++){
                graph[i][j] = Integer.parseInt(input[j]);
                queue.offer(new int[]{i, j});
            }
        }

        //dfs 수행 -> 두개의 섬으로 나눠질때까지 수행
        islandNum = queue.size();
        while(!queue.isEmpty()){
            int[] now = queue.peek();
            int i = now[0]; int j = now[1];
            //빙산이라면 dfs 수행
            if(graph[i][j] != 0){
                visitedNum = 0;
                dfs(i, j, new boolean[row][col]);

                //두개로 나눠지기 전에 빙산이 다 녹았다면
                if (islandNum == 0){
                    time = 0;
                    break;
                }
                //두개로 나뉘어졌다면 -> 남은 빙산의 개수와 현재 dfs로 방문한 빙산의 개수가 다르다면
                if(visitedNum != islandNum) break;

                //빙산을 다 녹였으면 시간 증가
                time++;
            }

            //현재 빙산을 녹였다면
            if(graph[i][j] == 0) queue.poll();
        }

        bw.write(time + "\n");
        bw.flush();
    }
}
