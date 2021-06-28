package Chapter05.actualproblem04;

import java.util.*;

class Node2{

    private int x;
    private int y;

    public Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class MySourceCode2 {

    public static int n, m;
    public static int[][] graph;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void bfs(int startX, int startY){
        Queue<Node2> queue = new LinkedList<>();
        //큐에 시작노드 삽입
        queue.offer(new Node2(startX, startY));

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Node2 now = queue.poll();
            int nowX = now.getX();
            int nowY = now.getY();

            //네 방향에 대해서 반복
            for(int i = 0; i < 4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                //미로를 벗어나면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //괴물이 있다면 무시
                if(graph[nx][ny] == 0) continue;

                //방문하지 않은 노드라면 큐에 삽입 후 1을 더함
                if(graph[nx][ny] == 1){
                    queue.offer(new Node2(nx, ny));
                    graph[nx][ny] = graph[nowX][nowY] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //미로의 세로길이, 가로길이 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        //그래프 초기화
        graph = new int[n][m];

        //그래프 입력받기
        for(int i = 0; i < n; i++){
            String input = sc.nextLine();
            for(int j = 0; j < m; j++){
                int now = input.charAt(j) - '0';
                graph[i][j] = now;
            }
        }

        bfs(0,0);

        System.out.println(graph[n-1][m-1]);
    }
}
