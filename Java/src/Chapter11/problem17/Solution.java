package Chapter11.problem17;

import java.util.*;

class Virus implements Comparable<Virus>{

    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
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
    //번호가 낮은 순서대로 정렬
    @Override
    public int compareTo(Virus virus) {
        if(this.index < virus.index) return -1;
        else return 1;
    }
}

public class Solution {

    public static int n, k;             //시험관의 크기 n 과 바이러스의 최대 크기
    public static int[][] graph;        //시험관
    public static List<Virus> viruses = new ArrayList<>();
    public static int s, x, y;
    //동 서 남 북
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {-1,1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //시험관의 크기와 바이러스의 최대 크기 입력받기
        n = sc.nextInt();
        k = sc.nextInt();

        //시험관 초기화
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = sc.nextInt();
                //바이러스가 있으면 바이러스 정보 담음
                if(graph[i][j] != 0){
                    viruses.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        Collections.sort(viruses);
        Queue<Virus> queue = new LinkedList<>();
        for(int i = 0; i < viruses.size(); i++){
            queue.offer(viruses.get(i));
        }

        //s초뒤에 (x,y) 의 바이러스의 종류
        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        //BFS 수행
        while(!queue.isEmpty()){
            Virus virus = queue.poll();
            //원하는 시간이 되면 종료
            if(virus.getSecond() == s) break;
            //동 서 남 북 4가지 방향 방문
            for(int i = 0; i < 4; i++){
                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                //갈수 없는 곳이면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                //바이러스가 없는 곳이면 수행
                if(graph[nx][ny] == 0){
                    graph[nx][ny] = virus.getIndex();
                    queue.offer(new Virus(virus.getIndex(), virus.getSecond() + 1, nx, ny));
                }
            }
        }

        System.out.println(graph[x-1][y-1]);
    }
}
