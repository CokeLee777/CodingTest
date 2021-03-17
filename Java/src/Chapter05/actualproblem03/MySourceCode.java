package Chapter05.actualproblem03;

import java.util.*;

public class MySourceCode {

    public static int n, m;
    public static int[][] graph;
    public static boolean[][] visited;
    //동서남북 순서대로
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};

    public static void dfs(int x, int y){
        //방문처리
        visited[x][y] = true;
        //네 방향 모두 확인
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //벽이라면 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            //만약 방문하지 않았고 빈칸이라면 방문
            if(!visited[nx][ny] && graph[nx][ny] == 0){
                dfs(nx,ny);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //결과값 저장하기 위한 값
        int result = 0;
        //세로길이, 가로길이 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];
        visited = new boolean[n][m];
        sc.nextLine();

        //얼음틀의 형태 입력받기
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        //아이스크림 생성
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //방문하지 않았고 칸막이가 아니라면 아이스크림 생성
                if(!visited[i][j] && graph[i][j] != 1){
                    dfs(i,j);
                    result++;
                }
            }
        }

        System.out.println("result = " + result);
    }
}
