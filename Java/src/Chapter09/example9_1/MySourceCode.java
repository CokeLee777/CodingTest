package Chapter09.example9_1;

import java.util.*;
//노드와 간선을 저장 할 클래스 생성
class Node{

    private int index;
    private int distance;

    public Node(int index, int distance) {
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

    public static final int INF = (int)1e9; //무한을 의미하는 것으로 10억 설정
    //노드의 갯수, 간선의 갯수, 시작 노드 번호 설정
    public static int n, m, start;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    //방문 여부 저장할 배열 만들기
    public static boolean[] visited = new boolean[100001];
    //최단거리 테이블 만들기
    public static int[] d = new int[100001];
    //방문하지 않은 노드 중에서, 가장 최단거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode(){
        int min_value = INF;
        int index = 0;
        for(int i = 1; i <= n; i++){
            if(d[i] < min_value && !visited[i]){
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start){
        //시작 노드 방문처리
        visited[start] = true;
        //시작 노드는 거리가 0으로 처리
        d[start] = 0;
        //시작 노드를 거쳐 다른 노드로 가는 비용 계산
        for(int i = 0; i < graph.get(start).size(); i++){
            //{{},{},{start}} -> {Node1, Node2, Node3} -> Node2.getIndex()...
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }
        //시작 노드를 제외한 전체 n-1 개의 노드에 대해 반복
        for(int i = 0; i < n - 1; i++){
            //현재 최단 거리가 가장 짧은 노드를 꺼내서 방문처리
            int now = getSmallestNode();
            visited[now] = true;
            //현재 노드와 연결된 다른 노드를 확인
            for(int j = 0; j < graph.get(now).size(); j++){
                int cost = d[now] + graph.get(now).get(j).getDistance();
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < d[graph.get(now).get(j).getIndex()]){
                    d[graph.get(now).get(j).getIndex()] = cost;
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

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node>());
        }

        //모든 간선 정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //a 번 노드에서 b번 노드로 가는 비용이 c 라는 의미
            graph.get(a).add(new Node(b, c));
        }

        //최단 거리 테이블 INF으로 초기화
        Arrays.fill(d, INF);

        //다익스트라 최단 경로 알고리즘 수행
        dijkstra(start);

        //모든 노드로 가기 위한 최단 거리를 출력
        for(int i = 1; i <= n; i++){
            //도달할 수 없는 경우, 무한 출력
            if(d[i] == INF) System.out.println("INFINITY");
            //도달할 수 있는 경우 거리 출력
            else System.out.println(d[i]);
        }

    }
}
