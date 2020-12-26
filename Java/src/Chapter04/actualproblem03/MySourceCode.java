package Chapter04.actualproblem03;

import java.util.*;

public class MySourceCode {
    //맵의 크기, 현재위치, 현재 방향
    public static int n, m, x, y, direction;
    //방문한 곳을 저장하기 위한 맵
    public static int[][] visited = new int[50][50];
    //전체 맵
    public static int[][] map = new int[50][50];
    //북,동,남,서 방향
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static int tried = 0;

    //반시계 방향으로 회전하는 메서드
    public static void turnleft(){
        direction--;
        if(direction == -1) direction = 3;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //맵 크기 입력받기
        n = scanner.nextInt();
        m = scanner.nextInt();
        //현재 위치, 방향 입력받기
        x = scanner.nextInt();
        y = scanner.nextInt();
        direction = scanner.nextInt();
        //맵 입력 받기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        //현재 위치 방문처리
        visited[x][y] = 1;

        int result = 1;

        while(true){
            //현재 방향에서 왼쪽으로 회전
            turnleft();
            //앞으로 전진
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            //가봤거나 맵이 바다이면 처음으로 돌아가서 다시 수행
            if(map[nx][ny] == 1 || visited[nx][ny] == 1){
                tried++;
            }
            else{
                visited[nx][ny] = 1;
                x = nx;
                y = ny;
                result++;
                tried = 0;
                continue;
            }
            //네 방향 모두 이미 가본 칸이거나 바다로 되어있는 경우
            if(tried == 4){
                nx = x - dx[direction];
                ny = y - dy[direction];
                tried = 0;
                if(map[nx][ny] == 1){
                    break;
                }
                else{
                    x = nx;
                    y = ny;
                }
            }

        }

        System.out.println(result);
    }
}
