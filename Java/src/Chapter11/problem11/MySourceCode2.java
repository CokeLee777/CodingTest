package Chapter11.problem11;

import java.util.*;

class Snake{

    private int x;
    private int y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class TurnTime{

    private int time;
    private String direction;

    public TurnTime(int time, String direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public String getDirection() {
        return this.direction;
    }
}

public class MySourceCode2 {

    public static int n, k, l;      //보드의 크기, 사과의 개수, 뱀의 방향 변환 횟수
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int[][] graph;    //그래프
    public static List<TurnTime> turnTimes = new ArrayList<>();

    public static int turnRight(int direction) {
        direction += 1;
        return direction > 3 ? 0 : direction;
    }

    public static int turnLeft(int direction){
        direction -= 1;
        return direction < 0 ? 3 : direction;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //보드의 크기
        k = sc.nextInt();   //사과의 개수

        graph = new int[n][n];

        //사과의 위치 입력받기
        for(int i = 0; i < k; i++){
            int row = sc.nextInt();
            int column = sc.nextInt();

            graph[row-1][column-1] = 2;  //사과의 위치
        }

        graph[0][0] = 1;

        l = sc.nextInt();   //뱀의 방향 변환 횟수
        //총 시간
        int time = 0;
        //맨 위 맨 좌측에서 시작 방향은 오른쪽방향
        Queue<Snake> queue = new LinkedList<>();
        queue.offer(new Snake(0,0));
        int direction = 0;
        int x = 0;
        int y = 0;

        for(int i = 0; i < l; i++){
            //t초에 direction으로 방향을 바꿈
            int t = sc.nextInt();
            String d = sc.next();

            turnTimes.add(new TurnTime(t, d));
        }

        int count = 0;  //회전 수

        //방향 변환 전 까지 반복
        while(!queue.isEmpty()){
            time += 1;
            //먼저 몸 길이를 늘려서 머리를 다음 칸에 위치시킨다.
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 이동한 곳이 벽이라면, 자기자신의 몸과 부딪힌다면 게임 종료
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || graph[nx][ny] == 1) {
                System.out.println(time);
                break;
            }
            //이동한 칸에 사과가 있다면 사과가 없어지고 꼬리 움직이지 X
            if(graph[nx][ny] == 2){
                graph[nx][ny] = 1;              //사과가 없어지고 뱀의 머리가 위치한다.
                queue.offer(new Snake(nx, ny));
            }
            //이동한 칸에 사과가 없다면 몸길이 변화 X
            else {
                graph[nx][ny] = 1;
                queue.offer(new Snake(nx, ny));
                //몸길이 변화 X -> 꼬리를 잘라준다.
                Snake tail = queue.poll();
                graph[tail.getX()][tail.getY()] = 0;
            }

            //뱀 머리의 위치 변경
            x = nx;
            y = ny;

            if(count < l && time == turnTimes.get(count).getTime()){
                //방향 전환을 해야한다면
                if(turnTimes.get(count).getDirection().equals("L")) direction = turnLeft(direction);
                if(turnTimes.get(count).getDirection().equals("D")) direction = turnRight(direction);

                count += 1;
            }
        }
    }
}
