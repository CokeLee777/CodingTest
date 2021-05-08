package Chapter11.problem46;

import java.util.*;

/**
 * 처음 아기상어의 크기 = 2
 * 아기상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다
 * 아기상어는 자신의 크기보다 작은 물고기만 먹을 수 있고, 크기가 같다면 먹지는 못하고 지나갈 수 있다.
 */

class Node{

    private int x;
    private int y;

    public Node(int x, int y) {
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

    public static int n, startX, startY;
    public static int time = -1;
    public static int size = 2;
    public static int[] fish = new int[7];
    public static int[][] graph;
    // 북 서 남 동
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};

    public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        //큐에 시작위치 삽입
        queue.offer(new Node(x, y));

        int eatCnt = 0;
        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int nowX = now.getX();
            int nowY = now.getY();
            time += 1;

            //먹을 수 있는 물고기가 없다면
            if(fish[size-1] == 0) break;

            //네 방향 모두에 대해서 물고기 찾기
            for(int i = 0; i < 4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                //벽이라면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                //먹을 수 없는 물고기라면 무시
                if(graph[nx][ny] > size) continue;
                //먹을 수 없지만 지나갈 수 있는 물고기라면 지나간다
                if(graph[nx][ny] == size){
                    queue.offer(new Node(nx, ny));
                    continue;
                }
                //먹을 수 있는 물고기인 경우
                if(graph[nx][ny] < size && graph[nx][ny] != 0){
                    queue.offer(new Node(nx, ny));
                    graph[nx][ny] = 0;
                    eatCnt += 1;
                    fish[size-1] -= 1;
                    if(eatCnt == size){
                        size += 1;
                        eatCnt = 0;
                    }
                    continue;
                }
                //빈칸인 경우
                if(graph[nx][ny] == 0){
                    queue.offer(new Node(nx, ny));
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        //그래프의 크기 입력받기
        n = sc.nextInt();
        //그래프 입력받기
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 9){
                    startX = i;
                    startY = j;
                    graph[i][j] = 0;
                }
                if(graph[i][j] >= 1 && graph[i][j] <= 6){
                    fish[graph[i][j]] += 1;
                }
                //먹을 수 있는 물고기가 있다면
                if(graph[i][j] == 1) flag = true;
            }
        }

        if(flag == true){
            bfs(startX, startY);
            System.out.println(time);
        } else {
            System.out.println(0);
        }


    }
}
