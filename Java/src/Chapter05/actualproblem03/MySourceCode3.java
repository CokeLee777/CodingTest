package Chapter05.actualproblem03;

import java.util.*;

public class MySourceCode3 {

    public static int[][] graph;
    public static boolean[][] visited;
    public static int n, m;

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void dfs(int nowX, int nowY){
        //시작 노드 방문처리
        visited[nowX][nowY] = true;
        //네 방향 모두 방문
        for(int i = 0; i < 4; i++){
            int nx = nowX + dx[i];
            int ny = nowY + dy[i];
            //벽이거나 칸막이면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || graph[nx][ny] == 1) continue;
            //아니면 방문
            if(!visited[nx][ny]) dfs(nx, ny);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        graph = new int[n][m];
        visited = new boolean[n][m];

        int result = 0;

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 0 && !visited[i][j]){
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.println("result = " + result);

    }
}
