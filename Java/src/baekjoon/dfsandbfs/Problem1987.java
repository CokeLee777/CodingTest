package baekjoon.dfsandbfs;

import java.io.*;

public class Problem1987 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //그래프의 행, 열 입력받기
        String[] input = br.readLine().split(" ");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        //그래프 입력받기
        char[][] graph = new char[row][col];
        for(int i = 0; i < row; i++){
            char[] charArr = br.readLine().toCharArray();
            for(int j = 0; j < col; j++){
                graph[i][j] = charArr[j];
            }
        }

        //dfs 수행
        int min = dfs(graph, new StringBuilder(), 0, 0);

        bw.write(min + "\n");
        bw.flush();
    }

    private static int dfs(char[][] graph, StringBuilder temp, int x, int y){
        //이미 가본곳이거나 벽이라면
        if(x < 0 || y < 0 || x >= graph.length || y >= graph[0].length ||
                temp.indexOf(Character.toString(graph[x][y])) != -1)
            return temp.length();

        //아니라면
        temp.append(graph[x][y]);
        //네방향 모두 탐색
        int max = Math.max(
                Math.max(dfs(graph, temp, x + 1, y), dfs(graph, temp, x - 1, y)),
                Math.max(dfs(graph, temp, x, y + 1), dfs(graph, temp, x, y - 1))
        );
        temp.deleteCharAt(temp.length()-1);

        return max;
    }
}
