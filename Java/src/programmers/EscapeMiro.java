package programmers;

import java.util.*;

public class EscapeMiro {

    public static final int INF = (int)1e9;
    public static int[][] graph;
    public static List<Integer> trapList = new ArrayList<>();

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {

        //그래프 초기화
        graph = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) graph[i][j] = 0;
            }
        }

        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
        }

        //트랩 리스트 초기화
        for (int trap : traps) {
            trapList.add(trap);
        }

        for(int k = 1; k <= n; k++){
            for(int a = 1; a < n; a++){
                for(int b = 1; b <= n; b++){
                    if(trapList.contains(k)){
                        for(int i = 1; i < graph[k].length; i++){
                            int temp = graph[k][i];
                            graph[k][i] = graph[i][k];
                            graph[i][k] = temp;
                        }
                    }

                    graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
                }
            }
        }

        return graph[start][end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] roads = {{1,2,1},{3,2,1},{2,4,1}};
        int[] traps = {2,3};

        int answer = solution(4, 1, 4, roads, traps);

        System.out.println("answer = " + answer);
    }
}
