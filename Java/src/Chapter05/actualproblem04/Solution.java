package Chapter05.actualproblem04;

import java.util.*;

class Node{
    private int index;
    private int distance;

    Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

}

public class Solution {

    public static int[][] graph = new int[201][201];

    public static boolean[][] visited = new boolean[201][201];

    //상, 하, 좌, 우
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static int n;
    public static int m;

    public static int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(x,y));     //큐에 삽입

        while(!queue.isEmpty()){
            Node node = queue.poll();   //queue에서 하나를 반환하고 제거
            //현재 동빈이의 위치를 node 객체의 메서드로부터 호출
            x = node.getIndex();
            y = node.getDistance();
            //네 방향의 위치 확인
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //미로를 이탈하는 경우
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //괴물이 있는 부분인 경우
                if(graph[nx][ny] == 0) continue;
                //특정 노드를 처음 방문하는 경우
                if(graph[nx][ny] == 1){
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.offer(new Node(nx,ny));
                }
            }
        }

        return graph[n-1][m-1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // n행 m열의 미로
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();          //버퍼 지우기

        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }
}
