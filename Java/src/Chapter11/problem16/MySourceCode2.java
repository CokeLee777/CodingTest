package Chapter11.problem16;

import java.util.*;

public class MySourceCode2 {

    public static int n, m;
    public static int[][] graph;
    public static int[][] temp;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static int findSafeZone(int[][] temp){

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(temp[i][j] == 0) count++;
            }
        }

        return count;
    }

    public static void dfs(int x, int y){

        //네 방향 모두 방문
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            if(temp[nx][ny] == 0){
                temp[nx][ny] = 2;
                dfs(nx,ny);
            }
        }
    }

    public static int setWall(){

        //랜덤으로 벽을 3개 세운다.
        int count = 0;
        int result = 0;

        for(int x = 0; x < n; x++){
            for(int y = 0; y < m; y++){
                if(temp[x][y] == 0){
                    temp[x][y] = 1;
                    count += 1;
                }
                for(int z = 0; z < m; z++){
                    if(temp[x][z] == 0){
                        temp[x][z] = 1;
                        count += 1;
                    }

                    if(count == 3){
                        for(int a = 0; a < n; a++){
                            for(int b = 0; b < m; b++){
                                //세워진 벽에 따라 dfs 수행
                                if(temp[a][b] == 2) dfs(a, b);
                            }
                        }
                        int tempResult = findSafeZone(temp);    //안전영역 크기 구하기
                        result = Math.max(result, tempResult);  //전에 구했던 안전영역 크기와 비교
                        //초기화
                        for(int i = 0; i < temp.length; i++){
                            System.arraycopy(graph[i], 0, temp[i], 0, graph[0].length);
                        }
                        count = 0;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //그래프의 세로 크기
        m = sc.nextInt();   //그래프의 가로 크기

        //그래프 초기화
        graph = new int[n][m];
        //그래프 입력받기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        temp = new int[n][m];
        for(int i = 0; i < graph.length; i++){
            System.arraycopy(graph[i], 0, temp[i], 0, graph[0].length);
        }

        int result = setWall();

        System.out.println(result);

    }
}
