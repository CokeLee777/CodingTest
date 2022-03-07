package baekjoon.dfsandbfs;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Problem16724 {

    private static int row, col;
    private static char[][] graph;
    private static int[] parent;
    //2차원 배열의 인덱스를 1차원 배열의 인덱스로 인덱싱
    private static int findIdx(int x, int y){
        int nx = x;
        int ny = y;

        //방향 이동
        if(graph[nx][ny] == 'D') nx++;
        else if (graph[nx][ny] == 'U') nx--;
        else if (graph[nx][ny] == 'L') ny--;
        else if (graph[nx][ny] == 'R') ny++;

        return nx * col + ny;
    }

    private static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //행, 열의 개수 입력받기
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);

        //그래프 입력받기
        graph = new char[row][col];
        for(int i = 0; i < row; i++){
            String s = br.readLine();
            for(int j = 0; j < col; j++){
                graph[i][j] = s.charAt(j);
            }
        }

        //부모 테이블 초기화
        parent = new int[row * col];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        //그래프 탐색
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int curIdx = i * col + j;
                int nextIdx = findIdx(i, j);
                //두개의 노드가 처리되지 않았다면 합친다
                if(findParent(curIdx) != findParent(nextIdx)){
                    unionParent(curIdx, nextIdx);
                }
            }
        }

        //집합의 개수를 센다
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < parent.length; i++){
            set.add(findParent(i));
        }

        bw.write(set.size() + "\n");
        bw.flush();
    }
}
