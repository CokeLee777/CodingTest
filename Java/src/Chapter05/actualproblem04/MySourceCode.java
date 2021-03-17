package Chapter05.actualproblem04;

import java.util.*;

class Node1{

    private int x;
    private int y;

    public Node1(int x, int y) {
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

public class MySourceCode {

    public static int n, m;         //세로, 가로크기
    public static int[][] graph;    //맵 정보
    //동서남북 방향
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void bfs(int x, int y){
        Queue<Node1> queue = new LinkedList<>();
        //첫 노드 큐에 삽입
        queue.offer(new Node1(x,y));
        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Node1 now = queue.poll();
            int nowX = now.getX();
            int nowY = now.getY();
            //네 방향 반복
            for(int i = 0; i < 4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                //벽이면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //처음 가본 곳이면 수행
                if(graph[nx][ny] == 1){
                    graph[nx][ny] = graph[nowX][nowY] + 1;
                    queue.offer(new Node1(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //맵의 세로, 가로크기 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();  //버퍼 지우기

        //맵 정보 입력받기
        graph = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = sc.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        //미로 이동 수행
        bfs(0,0);

        System.out.println(graph[n-1][m-1]);
    }

}
