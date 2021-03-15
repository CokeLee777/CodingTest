package Chapter04.actualproblem03;

import java.util.*;

public class MySourceCode {

    public static int n, m;             //맵의 세로크기, 가로크기
    public static boolean[][] visited;  //방문처리 그래프
    public static int[][] graph;        //그래프
    //북, 동, 남, 서
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static int turnLeft(int direction){
        direction -= 1;
        if(direction < 0) direction = 3;

        return direction;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //맵의 세로, 가로크기를 입력받는다.
        n = sc.nextInt();
        m = sc.nextInt();
        //캐릭터의 위치와 방향을 입력받는다.
        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();
        //방문처리 그래프, 맵 초기화
        visited = new boolean[n][m];
        graph = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        visited[x][y] = true;
        int result = 1;

        while(true){
            //왼쪽으로 회전
            direction = turnLeft(direction);
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            //가보지 않은 칸이라면 전진
            if(graph[nx][ny] == 0 && !visited[nx][ny]){
                x = nx;
                y = ny;
                visited[nx][ny] = true;
                result++;
                continue;
            }
            //가본 칸이라면 무시
            if(graph[nx][ny] == 0 && visited[nx][ny]) continue;
            //네 방향 모두 가본 칸이거나 바다로 되어있는 경우
            if(graph[nx][ny] == 1 || visited[nx][ny]){
                //뒤쪽 방향이 바다인 칸이라면 종료
                if(graph[x-dx[direction]][y-dy[direction]] == 1) break;
                //아니라면 뒤로 이동
                else{
                    x -= dx[direction];
                    y -= dy[direction];
                    //뒤쪽칸을 가보지 않았다면 횟수 증가
                    if(!visited[x][y]){
                        result++;
                        visited[x][y] = true;
                    }
                }
            }

        }

        System.out.println("result = " + result);

    }
}
