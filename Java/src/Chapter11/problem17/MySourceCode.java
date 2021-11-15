package Chapter11.problem17;

import java.util.*;

class Virus2 implements Comparable<Virus2> {

    private int index;
    private int second;
    private int x;
    private int y;

    public Virus2(int index, int second, int x, int y) {
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public int getSecond(){
        return second;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Virus2 v) {
        if(this.index < v.index) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static int n, k, s, x, y;
    public static int[][] graph;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static List<Virus2> viruses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //시험관의 크기
        k = sc.nextInt();   //바이러스는 k이하의 자연수

        graph = new int[n+1][n+1];

        Queue<Virus2> queue = new LinkedList<>();

        //시험관 정보 입력받기
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] != 0) viruses.add(new Virus2(graph[i][j], 0, i, j));
            }
        }

        Collections.sort(viruses);

        for(int i = 0; i < viruses.size(); i++){
            queue.offer(new Virus2(viruses.get(i).getIndex(), viruses.get(i).getSecond(), viruses.get(i).getX(),viruses.get(i).getY()));
        }

        s = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        while(!queue.isEmpty()){
            Virus2 virus = queue.poll();
            int index = virus.getIndex();
            int second = virus.getSecond();
            int x = virus.getX();
            int y = virus.getY();

            //사간이 다 되었다면 종료
            if(second == s) break;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //벽이라면 무시
                if(nx <= 0 || nx > n || ny <= 0 || ny > n) continue;

                if(graph[nx][ny] == 0){
                    graph[nx][ny] = index;
                    queue.offer(new Virus2(index, second+1, nx, ny));
                }
            }
        }

        System.out.println(graph[x][y]);
    }
}
