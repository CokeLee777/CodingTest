package Chapter11.problem13;

import java.util.*;

class Chicken implements Comparable<Chicken> {

    private int x;
    private int y;
    private int distance;

    public Chicken(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Chicken c) {
        if(this.distance < c.distance) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static int n, m; //도시의 크기, 폐업시키지 않을 치킨집의 개수
    public static int[][] graph;    //도시 정보
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static PriorityQueue<Chicken> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //도시의 크기
        m = sc.nextInt();   //폐업시키지 않을 치킨집의 최대 수

        //그래프 입력받기
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        //dfs 수행
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 2) {

                }
            }
        }

        int answer = 0;


        System.out.println(answer);
    }
}
