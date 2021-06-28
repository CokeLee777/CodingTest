package Chapter05.example5_9;

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

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        //큐에 시작노드 삽입하고 방문처리
        queue.offer(start);
        visited[start] = true;
        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            //큐에서 노드 하나를 꺼낸다
            Integer now = queue.poll();
            System.out.print(now + " ");

            //현재 노드와 연결된 노드중 방문하지 않은 노드 방문
            for (int i : graph[now]) {
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        bfs(1);
    }
}
