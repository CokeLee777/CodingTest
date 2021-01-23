package Chapter09.example9_1;

import java.util.*;

class Node1{
    private int index;
    private int distance;

    public Node1(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static int n, m, start;                          //노드의 갯수, 간선의 갯수, 시작 노드번호
    public static int[] d = new int[100001];                //최단거리 테이블
    public static boolean[] visited = new boolean[100001];  //방문여부 테이블
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();    //그래프

    public static int getSmallestNode(){
        int index = 0;
        int min_value = INF;
        for(int i = 1; i <= n; i++){
            if(!visited[i] && d[i] < min_value){
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dyikstra(int start){
        //출발 노드 초기화
        d[start] = 0;
        visited[start] = true;
        for(int i = 0; i < graph.get(start).size(); i++){
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }
        //출발 노드를 제외한 나머지 노드 수행
        for(int i = 0; i < n - 1; i++){
            //방문하지 않은 노드 중 거리가 가장 짧은 노드 반환
            int now = getSmallestNode();
            //방문처리
            visited[now] = true;

            for(int j = 0; j < graph.get(now).size(); j++){
                int sum = d[now] + graph.get(now).get(j).getDistance();
                if(sum <= d[graph.get(now).get(j).getIndex()]){
                    d[graph.get(now).get(j).getIndex()] = sum;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드의 갯수, 간선의 갯수, 시작 노드번호 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node1>());
        }

        //그래프 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //노드 a에서 b로가는 거리가 c라는 의미
            graph.get(a).add(new Node1(b,c));
        }

        //최단거리 테이블 무한대로 초기화
        Arrays.fill(d, INF);

        //다익스트라 알고리즘 수행
        dyikstra(start);

        //출력
        for(int i = 1; i <= n; i++){
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }
}
