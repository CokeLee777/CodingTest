package Chapter11.problem11;

import java.util.*;

class Turn implements Comparable<Turn>{

    private int time;
    private String type;

    public Turn(int time, String type) {
        this.time = time;
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Turn turn) {
        if(this.time < turn.time) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static int n, k, l;  //보드의 크기, 사과의 개수, 뱀의 방향 변환 수
    public static int[][] snake;
    public static boolean[][] graph;
    public static PriorityQueue<Turn> pq = new PriorityQueue<>();
    //오른쪽, 아래, 왼쪽, 위쪽 순서의 이동
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};

    public static int turn(int turnTime){
        if(turnTime > 3) return 0;
        else if(turnTime < 0) return 3;
        else return turnTime;
    }

    public static int snake(int startRow, int startCol){
        int result = 0;
        int x = 1;
        int y = 1;
        int turnTime = 0;
        snake[startCol][startRow] = 1;

        while(!pq.isEmpty()){
            Turn now = pq.poll();
            int time = now.getTime();
            String type = now.getType();
            //전의 시간에서 빼준다.
            time -= result;
            //방향변환하기 전까지 반복
            for(int i = 0; i < time; i++){
                result += 1;
                int nx = x + dx[turnTime];
                int ny = y + dy[turnTime];
                //가는길이 벽이라면 종료
                if(nx <= 0 || nx > n || ny <= 0 || ny > n) break;
                //머리와 꼬리가 만나면 종료
                if(snake[nx][ny] == 1) break;
                //가는길에 사과가 있다면 길이가 늘어난다
                if(graph[nx][ny]) {
                    snake[nx][ny] = 1;
                    x = nx;
                    y = ny;
                }
                //가는길에 사과가 없다면
                else{
                    snake[x][y] = 0;
                    snake[nx][ny] = 1;
                    x = nx;
                    y = ny;
                }
            }
            //오른쪽회전인지 왼쪽회전인지 구분
            if(type.equals("D")){
                turnTime = turn(turnTime + 1);
            }
            if(type.equals("L")){
                turnTime = turn(turnTime - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //그래프 크기와 그래프 초기화
        n = sc.nextInt();
        graph = new boolean[n+1][n+1];
        snake = new int[n+1][n+1];
        //사과의 갯수 k, 사과의 위치 입력받기
        k = sc.nextInt();
        for(int i = 0; i < k; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            graph[row][col] = true;
        }
        l = sc.nextInt();
        //방향 변환 시간, 방향 입력받기
        for(int i = 0; i < l; i++){
            int time = sc.nextInt();
            //D : 오른쪽으로 90도 회전, L : 왼쪽으로 90도 회전
            String turn = sc.next();
            pq.offer(new Turn(time, turn));
        }

        int result = snake(1, 1);
        System.out.println("result = " + result);
    }
}
