package Chapter11.problem15;

import java.util.*;

public class MySourceCode {
    //도시(노드)의 갯수, 도로(간선)의 갯수, 거리 정보, 출발 도시(노드)의 번호
    public static int n, m, k, x;
    //최단 거리 테이블
    public static int[] d;
    //그래프
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //방문처리
    public static boolean[] visited;

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        //출발도시 초기화
        queue.offer(start);
        visited[start] = true;
        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            Integer now = queue.poll();

            for(int i = 0; i < graph.get(now).size(); i++){
                if(!visited[graph.get(now).get(i)]){
                    //아직방문하지 않은 노드라면 큐에 삽입
                    queue.offer(graph.get(now).get(i));
                    //전의 거리와 비교
                    if(d[graph.get(now).get(i)] == 0){
                        d[graph.get(now).get(i)] = d[now] + 1;
                    } else {
                        d[graph.get(now).get(i)] = Math.min(d[now] + 1, d[graph.get(now).get(i)]);
                    }

                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //도시의 개수 입력받기
        m = sc.nextInt();   //도로의 개수 입력받기
        k = sc.nextInt();   //최단거리 입력받기
        x = sc.nextInt();   //출발도시 입력받기
        //그래프와 최단거리 테이블 초기화
        d = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }
        //그래프 정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        bfs(x);

        boolean flag = false;
        for(int i = 1; i < n + 1; i++){
            if(d[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if(!flag) System.out.println(-1);

    }
}
