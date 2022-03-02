package baekjoon.dfsandbfs;

import java.util.Scanner;

public class Problem16724 {
    private static int cycle = 0;

    private static int move(char[][] graph, int[][] cycleNum, boolean[][] visited, int x, int y){
        int nx = x;
        int ny = y;

        while(!visited[nx][ny]){
            if(cycleNum[nx][ny] != 0 && cycleNum[nx][ny] != cycle)
                return 0;
            visited[nx][ny] = true;
            cycleNum[nx][ny] = cycle+1;
            //방향 이동
            if(graph[nx][ny] == 'D') nx++;
            else if (graph[nx][ny] == 'U') nx--;
            else if (graph[nx][ny] == 'L') ny--;
            else if (graph[nx][ny] == 'R') ny++;
        }

        return 1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //행, 열의 개수 입력받기
        int row = in.nextInt();
        int col = in.nextInt();
        in.nextLine();
        //그래프 입력받기
        char[][] graph = new char[row][col];
        for(int i = 0; i < row; i++){
            String input = in.nextLine();
            for(int j = 0; j < col; j++){
                graph[i][j] = input.charAt(j);
            }
        }

        boolean[][] visited = new boolean[row][col];
        int[][] cycleNum = new int[row][col];
        //그래프 탐색
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j]){
                    cycle += move(graph, cycleNum, visited, i, j);
                }
            }
        }

        System.out.println(cycle);
    }
}
