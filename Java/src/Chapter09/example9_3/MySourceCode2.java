package Chapter09.example9_3;

import java.util.*;

public class MySourceCode2 {

    public static final int INF = (int)1e9;
    public static int n, m;
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드의 개수 간선의 개수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //그래프 초기화
        graph = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }
        //자기자신으로 가는 비용 0으로 초기화
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
            }
        }

        //노드에 대한 간선 정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a][b] = c;
        }

        //플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <=n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        //결과 출력
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                System.out.println("graph[a][b] = " + graph[a][b]);
            }
        }
    }
}
