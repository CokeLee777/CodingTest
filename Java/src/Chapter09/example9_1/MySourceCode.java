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

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

public class MySourceCode {

    public static int n, m, start;          //노드의 갯수, 간선의 갯수, 시작 노드번호
    public static boolean[] visited;        //방문여부 배열
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();    //노드, 간선의 정보를 담고있는 리스트
    public static final int INF = (int)1e9; //무한대 상수
    public static int[] d;

    public static int smallestNode(){
        int min_value = INF;
        int index = 0;
        //방문하지 않은 노드중에서 최단거리가 가장 짧은 노드를 반환
        for(int i = 1; i <= n; i++){
            if(!visited[i] && d[i] < min_value){
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dyikstra(int start){
        //시작 위치 방문처리 및 초기화
        visited[start] = true;
        d[start] = 0;
        for(int i = 0; i < graph.get(start).size(); i++){
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }
        //나머지 n-1개 노드 다익스트라 알고리즘 수행
        for(int i = 0; i < n - 1; i++){
            //최단거리가 가장 짧은 노드 반환
            int node = smallestNode();
            //방문처리
            visited[node] = true;
            //현재 노드와 연결된 다른 노드 다익스트라 알고리즘 수행
            for(int j = 0; j < graph.get(node).size(); j++){
                int cost = graph.get(node).get(j).getDistance();
                if(cost + d[node] < d[graph.get(node).get(j).getIndex()]){
                    d[graph.get(node).get(j).getIndex()] = cost + d[node];
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
        //그래프, 방문처리 배열 초기화
        visited = new boolean[n + 1];
        d = new int[n + 1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //노드 a에서 b로 가는 비용이 c라는 의미
            graph.get(a).add(new Node1(b, c));
        }
        //최단거리 테이블을 INF로 초기화
        Arrays.fill(d, INF);

        dyikstra(start);

        for(int i = 1; i < d.length; i++){
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }
}
