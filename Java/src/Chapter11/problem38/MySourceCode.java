package Chapter11.problem38;

import java.util.*;

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static int n, m;
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //학생들의 수, 두 학생의 성적을 비교한 횟수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];

        //최단거리 테이블 초기화
        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }

        //자신한테 가는 비용 0으로 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) graph[i][j] = 0;
            }
        }

        //두 학생의 성적을 비교한 것을 입력받는다
        for(int i = 0; i < m; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[A][B] = 1;
        }

        //폴로이드 워셜 알고리즘 수행
        for(int k = 0; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        //도달할 수 없는 경우 count 증가
        int result = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] != INF || graph[j][i] != INF) cnt +=1;
            }

            if(cnt == n) result += 1;
        }

        System.out.println(result);
    }
}
