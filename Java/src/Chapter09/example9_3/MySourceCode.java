package Chapter09.example9_3;

import java.util.*;

public class MySourceCode {

    public static final int INF = (int)1e9; //'무한'을 의미하는 상수 설정
    public static int n, m; //노드의 갯수와 간선의 갯수 입력받기
    public static int[][] graph = new int[501][501];    //그래프 입력받기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드의 갯수와 간선의 갯수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //그래프 무한으로 초기화
        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }
        //자기 자신에서 자신으로 가는 비용 0으로 초기화
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a == b) graph[a][b] = 0;
            }
        }
        //노드에 대한 간선정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //노드a 에서 노드b로 가는 거리가 c라는 뜻
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
        //결과 출력하기
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(graph[a][b] == INF){
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
