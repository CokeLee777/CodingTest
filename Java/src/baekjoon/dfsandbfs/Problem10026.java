package baekjoon.dfsandbfs;

import java.io.*;

public class Problem10026 {

    private static int n;
    private static int normalArea, unNormalArea;
    private static char[][] graph;
    private static boolean[][] visited;

    private static final int[] dx = new int[]{0,0,1,-1};
    private static final int[] dy = new int[]{1,-1,0,0};

    private static void dfs(int x, int y){
        visited[x][y] = true;

        //같은 색상인 색상 방문
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //범위를 벗어나거나 이미 방문했다면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
                continue;

            if(graph[x][y] == graph[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //그래프 크기 입력받기
        n = Integer.parseInt(br.readLine());

        //그래프 초기화
        graph = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                graph[i][j] = s.charAt(j);
            }
        }
        //색약이 아닌 사람 dfs 수행
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]) {
                    dfs(i, j);
                    normalArea++;
                }
            }
        }

        //색약인 사람 dfs하기 위해 G를 R로 바꿔줌
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 'G') graph[i][j] = 'R';
            }
        }

        //색약인 사람 dfs수행
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    unNormalArea++;
                }
            }
        }

        bw.write(normalArea + " " + unNormalArea);
        bw.flush();
    }
}
