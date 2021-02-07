package Chapter09.example9_2;

import java.util.*;

class Node implements Comparable<Node>{

    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Node node) {
        if(this.distance < node.distance) return -1;
        else return 1;
    }
}

public class Solution {

    public static final int INF = (int)1e9;
    public static int n, m, start;
    public static int[] d = new int[100001];
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void dijkstra(int start){
        //우선순위 큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작노드 초기화 출발위치에서 거리는 0
        pq.offer(new Node(start, 0));
        d[start] = 0;
        //큐가 빌때까지 반복
        while(!pq.isEmpty()) {
            //가장 거리가 짧은 노드 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance();  //현재 노드까지의 비용
            int now = node.getIndex();    //현재 노드
            //현재 노드가 이미 처리된 노드라면 무시
            if(d[now] < dist) continue;
            //현재 노드와 연결된 다른 노드를 확인한다.
            for(int i = 0; i < graph.get(now).size(); i++){
                int sum = d[now] + graph.get(now).get(i).getDistance();
                if(sum <= d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = sum;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), sum));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드의 갯수, 간선의 갯수, 시작노드 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        //그래프 입력받기
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            //a에서 b로가는 비용이 c
            graph.get(a).add(new Node(b,c));
        }
        //최단거리 테이블 초기화
        Arrays.fill(d, INF);

        //빠른 다익스트라 알고리즘 수행
        dijkstra(start);

        //출력
        for(int i = 1; i <= n; i++){
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }
}
