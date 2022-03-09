package baekjoon.dfsandbfs;

import java.io.*;
import java.util.*;

public class Problem16946 {

    private static int row, col;
    private static int[][] graph;
    private static int[][] group;
    private static Map<Integer, Integer> groupToCnt = new HashMap<>();
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static int bfs(int x, int y, int groupNum){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        //그룹번호 부여
        group[x][y] = groupNum;

        int cnt = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            cnt++;

            for(int i = 0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                //벽이거나 맵 밖이면 무시
                if(nx < 0 || nx >= row || ny < 0 || ny >= col || graph[nx][ny] == 1)
                    continue;
                //그룹번호가 부여되지 않았다면 큐에 삽입
                if(group[nx][ny] != groupNum && graph[nx][ny] != 1){
                    queue.offer(new int[]{nx, ny});
                    group[nx][ny] = groupNum;
                }
            }
        }

        return cnt;
    }

    private static int findEmptyBlock(int x, int y){
        Set<Integer> set = new HashSet<>();
        //4방향 모두 방문
        int cnt = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //벽이거나 맵 밖이면 무시
            if(nx < 0 || nx >= row || ny < 0 || ny >= col || graph[nx][ny] == 1)
                continue;
            //그룹번호가 부여되었으면 그룹번호에 대한 개체수를 센다
            if(graph[nx][ny] == 0 && !set.contains(group[nx][ny])){
                cnt += groupToCnt.get(group[nx][ny]);
                set.add(group[nx][ny]);
            }
        }

        return cnt % 10;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //행, 열의 개수 입력받기
        String[] input = br.readLine().split(" ");

        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);

        //그래프 입력받기
        graph = new int[row][col];
        for(int i = 0; i < row; i++){
            input = br.readLine().split("");
            for(int j = 0; j < col; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        //그룹 번호 부여
        group = new int[row][col];
        int groupNum = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(group[i][j] == 0 && graph[i][j] == 0){
                    groupToCnt.put(groupNum, bfs(i, j, groupNum));
                    groupNum++;
                }
            }
        }

        //그래프를 돌면서 벽 부수고 이동
        StringBuilder results = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(graph[i][j] == 1){
                    results.append(findEmptyBlock(i, j));
                } else {
                    results.append("0");
                }
            }
            results.append("\n");
        }

        bw.write(results.toString());
        bw.flush();
    }
}
