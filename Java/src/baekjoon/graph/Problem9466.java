package baekjoon.graph;

import java.io.*;

public class Problem9466 {

    private static int n, tmp;
    private static int[] parent;

    private static int findParent(int x){
        if(x == parent[x]) return x;
        tmp++;
        return parent[x] = findParent(parent[x]);
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
            n = Integer.parseInt(br.readLine());
            //학생 입력받기
            String[] input = br.readLine().split(" ");
            //부모 테이블 초기화
            parent = new int[n+1];
            for(int i = 1; i < parent.length; i++){
                parent[i] = i;
            }

            //선택한 학생들 번호 입력받기
            int cnt = 0;
            for(int a = 1; a <= n; a++){
                int b = Integer.parseInt(input[a-1]);

                //사이클이 발생 했다면
                if(findParent(a) != findParent(b)){
                    cnt ++;
                } else {
                    if (a != b) {
                        tmp = 0;
                        findParent(b);
                        cnt -= tmp;
                    }
                }
                parent[a] = b;
            }

            results.append(n - cnt).append("\n");
        }

        bw.write(results.toString());
        bw.flush();
    }
}
