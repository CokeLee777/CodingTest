package baekjoon.graph;

import java.io.*;

public class Problem9466 {

    private static int tmp;
    private static int[] parent;
    private static boolean[] visited;

    private static int dfs(int now){
        if(visited[now]) return now;
        //방문처리
        visited[now] = true;
        tmp++;

        return dfs(parent[now]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트케이스의 개수 t 입력받기
        int t = Integer.parseInt(br.readLine());
        //테스트 수행
        StringBuilder results = new StringBuilder();
        for(int test = 0; test < t; test++){
            //학생의 수 입력받기
            int n = Integer.parseInt(br.readLine());
            //학생 입력받기
            String[] input = br.readLine().split(" ");
            //부모 테이블 초기화
            parent = new int[n+1];
            visited = new boolean[n+1];
            for(int i = 1; i < parent.length; i++){
                parent[i] = Integer.parseInt(input[i-1]);
            }
            //UnionParent 수행
            int count = n;
            for(int a = 1; a <= n; a++){
                tmp = 0;
                if(a == dfs(a)){
                    if(a == parent[a]) count--;
                    else count -= tmp;
                }
            }
            results.append(count).append("\n");
        }

        bw.write(results.toString());
        bw.flush();
    }
}
