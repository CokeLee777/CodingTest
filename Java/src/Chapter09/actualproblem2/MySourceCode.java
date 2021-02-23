package Chapter09.actualproblem2;

import java.util.*;

public class MySourceCode {

    public static final int INF = (int)1e9; //무한
    public static int n, m, x, k;  //노드의갯수 간선의갯수 목적지 경유지
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //회사의 갯수와 경로의 갯수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //그래프 INF으로 초기화
        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }
        //자기자신으로 가는 경로 0으로 초기화
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
            }
        }
        //그래프 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        //목적지와 경유지 입력받기
        x = sc.nextInt();
        k = sc.nextInt();
        //플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int result = graph[1][k] + graph[k][x];
        //결과 출력
        if(result >= INF){
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
}
