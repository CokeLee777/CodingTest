package com.company;

import java.util.*;

public class Main {

    public static final int INF = (int)1e9;
    public static int n, m, start;
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //노드의 개수 입력받기
        n = sc.nextInt();
        //간선의 개수 입력받기
        m = sc.nextInt();
        //시작 노드 입력받기
        start = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }
        //자기 자신으로 가는 거리 0으로 초기화
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == j) graph[i][j] = 0;
            }
        }
        //간선 정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a][b] = c;
        }

        //플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        //결과 출력
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(graph[a][b] == INF) System.out.print("INF ");
                else System.out.print(graph[a][b] + " ");
            }
        }
    }
}
