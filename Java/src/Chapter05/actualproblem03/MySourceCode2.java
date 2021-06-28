package Chapter05.actualproblem03;

import java.util.*;

public class MySourceCode2 {

    public static int n, m;
    public static int[][] graph;
    public static boolean[][] visited;
    //상하좌우
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void dfs(int nowX, int nowY){
        //현재 노드 방문처리
        visited[nowX][nowY] = true;

        //네 방향 모두 방문
        for(int i = 0; i < 4; i++){
            int nx = nowX + dx[i];
            int ny = nowY + dy[i];

            //얼음틀에서 벗어나면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            //방문하지 않았거나 칸막이가 아닌경우 방문
            if(!visited[nx][ny] && graph[nx][ny] == 0){
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;

        //얼음틀의 세로길이 n, 가로길이 m 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        //얼음틀 입력받기
        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String input = sc.nextLine();
            for(int j = 0; j < m; j++){
                int now = input.substring(j, j+1).charAt(0) - '0';
                graph[i][j] = now;
            }
        }

        //얼음 만들기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //칸막이가 아니고 구멍이 뚫려있다면 방문
                if(graph[i][j] == 0 && !visited[i][j]){
                    dfs(i, j);
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
