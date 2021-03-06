package Chapter11.problem16;

import java.util.*;

public class MySourceCode {
    //세로크기, 가로크기
    public static int n, m;
    //그래프
    public static int[][] graph;
    //상 하 좌 우 이동 배열
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static void dfs(int x, int y){
        //if(x >= n || x < 0) return;

        //바이러스 전염 수행(4 방향 수행)
        if(graph[x][y] == 2){
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //그래프 밖이면 무시
                if(nx >= n || nx < 0) return;
                //가로값이 넘어가면 다음줄로 이동
                if(ny >= m || ny < 0) dfs(nx, 0);
                //벽, 빈칸 이면 무시
                if(graph[nx][ny] == 1 || graph[nx][ny] == 0) dfs(nx, ny+1);

                if(graph[nx][ny] == 0){
                    graph[nx][ny] = 2;
                    dfs(nx, ny);
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //세로크기 , 가로크기 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //그래프 초기화
        graph = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        //dfs 수행
        dfs(0,0);
        //안전영역의 크기 찾기
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 0) count++;
            }
        }

        System.out.println("count = " + count);
    }
}
