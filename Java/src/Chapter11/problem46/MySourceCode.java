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

    public static int n, nowX, nowY;
    public static int size = 2;
    public static int time, ate;
    public static int[][] graph;
    // 북 서 남 동
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};

    public static final int INF = (int)1e9;

    //모든 위치까지의 최단거리만 계산
    public static int[][] bfs(){
        Queue<Node> queue = new LinkedList<>();
        //큐에 시작위치 삽입
        queue.offer(new Node(nowX, nowY));
        //최단거리 테이블 초기화
        int[][] distance = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(distance[i], -1);
        }
        //시작위치는 최단거리 0
        distance[nowX][nowY] = 0;

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Node now = queue.poll();
            int x = now.getX();
            int y = now.getY();
            //네 방향 모두 반복
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //벽이라면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                //벽이 아니라면 자신의 크기보다 작거나 같은 경우 지나감
                if(distance[nx][ny] == -1 && graph[nx][ny] <= size){
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return distance;
    }

    //먹을 수 있는 물고기를 찾는 함수
    public static int[] find(int[][] distance){
        int[] result = new int[3];
        int x = 0;
        int y = 0;
        int minDistance = INF;

        //먹을 수 있는 물고기들 중에서 최단거리에 있는 물고기 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //도달이 가능하면서 먹을 수 있는 물고기가 있을 때
                if(distance[i][j] != -1 && graph[i][j] >= 1 && graph[i][j] < size){
                    //가장 가까운 물고기 선택
                    if(distance[i][j] < minDistance){
                        x = i;
                        y = j;
                        minDistance = distance[i][j];
                    }
                }
            }
        }
        //결과값 배열에 담아 출력
        result[0] = x;
        result[1] = y;
        result[2] = minDistance;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //그래프의 크기 입력받기
        n = sc.nextInt();
        //그래프 입력받기
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        //아기상어의 시작 위치를 찾은 뒤 그 위치에 0 삽입
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 9){
                    nowX = i;
                    nowY = j;
                    graph[i][j] = 0;
                    break;
                }
            }
        }

        while(true){
            int[] result = find(bfs());
            //먹을 수 있는 물고기가 없는 경우
            if(result[2] == INF){
                System.out.println(time);
                return;
            } else {
                //현재위치 갱신 및 이동거리 합하기
                nowX = result[0];
                nowY = result[1];
                time += result[2];
                //먹은 위치 초기화
                graph[nowX][nowY] = 0;
                ate += 1;
                //크기증가가 가능하다면 크기 증가
                if(ate >= size){
                    size += 1;
                    ate = 0;
                }
            }
        }

    }
}
