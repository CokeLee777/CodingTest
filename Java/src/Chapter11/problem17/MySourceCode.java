package Chapter11.problem17;

import java.util.*;

public class MySourceCode {

    public static int n, k;             //시험관의 크기 n 과 바이러스의 최대 크기
    public static int[][] graph;        //시험관
    public static boolean[][] visited;  //방문처리 배열
    public static int s, x, y;
    //동 서 남 북
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};

    public static void dfs(int x, int y){
        //바이러스가 없는 칸이면 무시
        if(graph[x][y] != 0) return;
        //현재 노드 방문처리
        visited[x][y] = true;
        //네 방향 모두 확인
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //벽이면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            //방문하지 않았고 바이러스가 없으면 방문
            if(!visited[nx][ny] && graph[nx][ny] == 0){
                graph[nx][ny] = graph[x][y];
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //시험관의 크기와 바이러스의 최대 크기 입력받기
        n = sc.nextInt();
        k = sc.nextInt();

        //시험관 초기화
        graph = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        //s초뒤에 (x,y) 의 바이러스의 종류
        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        for(int k = 0; k < s; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){

                }
            }
        }
    }
}
