package Chapter05.actualproblem04;

import java.util.*;

class Node3 {

    private int x;
    private int y;

    public Node3(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class MySourceCode3 {

    public static int[][] graph;
    public static int n, m;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void bfs(){
        Queue<Node3> queue = new LinkedList<>();
        //동빈이의 시작 위치 큐에 삽입
        queue.offer(new Node3(0,0));
        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            Node3 node = queue.poll();
            int nowX = node.getX();
            int nowY = node.getY();
            //네방향 모두 방문
            for(int i = 0; i < 4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                //벽이거나 괴물이 있다면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //처음 방문한 곳이라면 방문
                if(graph[nx][ny] == 1){
                    queue.offer(new Node3(nx, ny));
                    graph[nx][ny] += graph[nowX][nowY];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        graph = new int[n][m];

        for(int i = 0; i < n; i++){
            String input = sc.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println("result = " + graph[n-1][m-1]);
    }

}
