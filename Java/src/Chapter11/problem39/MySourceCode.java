package Chapter11.problem39;

import java.util.*;

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static int t, n;
    public static int[][] graph;
    public static boolean[][] visited;
    //상 하 좌 우
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //테스트 케이스의 개수 입력받기
        t = sc.nextInt();

        //테스트 케이스만큼 반복
        for(int i = 0; i < t; i++){
            //그래프의 크기 입력받기
            n = sc.nextInt();
            //그래프 입력받기
            graph = new int[n][n];
            visited = new boolean[n][n];
            visited[0][0] = true;
            for(int a = 0; a < n; a++){
                for(int b = 0; b < n; b++){
                    graph[a][b] = sc.nextInt();
                }
            }

            int result = 0;

        }

    }
}
