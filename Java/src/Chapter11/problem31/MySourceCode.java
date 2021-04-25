package Chapter11.problem31;

import java.util.*;

public class MySourceCode {

    public static int t;
    public static int n, m;
    public static int[][] graph;
    public static int[] d;

    public static int dynamicProgramming(int sum){
        //다이나믹 테이블 초기화
        d = new int[n];
        //다이나믹 프로그래밍 수행
        for(int i = 0; i < n; i++){
            int idx = i;
            for(int j = 0; j < m; j++){
                if(j == 0){
                    d[i] = graph[i][j];
                    continue;
                }
                if(idx-1 < 0 && idx+1 < n){
                    d[i] += Math.max(graph[idx][j], graph[idx+1][j]);
                    if(Math.max(graph[idx][j], graph[idx+1][j]) == graph[idx+1][j]) idx += 1;
                    continue;
                }
                if(idx-1 >= 0 && idx+1 >= n){
                    d[i] += Math.max(graph[idx][j], graph[idx-1][j]);
                    if(Math.max(graph[idx][j], graph[idx-1][j]) == graph[idx-1][j]) idx -= 1;
                    continue;
                }

                d[i] += Math.max(graph[idx][j], Math.max(graph[idx+1][j], graph[idx-1][j]));
                if(Math.max(graph[idx][j], Math.max(graph[idx+1][j], graph[idx-1][j])) == graph[idx+1][j]){
                    idx += 1;
                    continue;
                }
                if(Math.max(graph[idx][j], Math.max(graph[idx+1][j], graph[idx-1][j])) == graph[idx-1][j]) idx -= 1;

            }
        }

        Arrays.sort(d);
        sum = d[n-1];
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();   //테스트 케이스 갯수

        //테스트 케이스 만큼 반복
        for(int cnt = 0; cnt < t; cnt++){
            n = sc.nextInt();   //행
            m = sc.nextInt();   //열
            graph = new int[n][m];
            //그래프 입력받기
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    graph[i][j] = sc.nextInt();
                }
            }

            int result = dynamicProgramming(0);
            System.out.println(result);
        }

    }
}
