package Chapter05.example5_8;

import java.util.*;

public class MySourceCode {

    public static int[][] graph = {
            {},
            {2,3,8},
            {1,7},
            {1,4,5},
            {3,5},
            {3,4},
            {7},
            {2,6,8},
            {1,7}
    };

    public static boolean[] visited = new boolean[9];

    /**
     * 깊이 우선 탐색: 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
     */
    public static void dfs(int now){
        //현재 노드 방문처리
        visited[now] = true;
        System.out.print(now + " ");

        //현재 노드와 연결된 노드중 방문하지 않은 노드 방문
        for (int i : graph[now]) {
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dfs(1);
    }
}
