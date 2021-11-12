package Chapter09.example9_2;

import java.util.*;

class Node1 implements Comparable<Node1>{

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

    @Override
    public int compareTo(Node1 node1) {
        if(this.distance < node1.distance) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static int n, m, start;
    public static List<List<Node1>> graph = new ArrayList<>();
    public static int[] d;

    private static void dyikstra(int start) {
        PriorityQueue<Node1> pq = new PriorityQueue<>();
        //우선순위 큐에 시작노드 삽입
        pq.offer(new Node1(start, 0));
        //시작노드는 거리가 0
        d[start] = 0;

        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            //우선순위 큐에서 꺼내므로 거리가 가장 짧은 것 부터 우선적으로 꺼낸다.
            Node1 node = pq.poll();
            int index = node.getIndex();
            int distance = node.getDistance();

            //이미 처리된 경우 무시 - 현재 노드의 최단거리 테이블이 INF가 아닌경우
            if(d[index] < distance) continue;

            //아닌 경우 경유하는 거리와 아닌경우 비교해서 짧은 거리 최단거리 테이블에 삽입
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node1(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //노드의 개수 입력받기
        n = sc.nextInt();
        //간선의 개수 입력받기
        m = sc.nextInt();
        //시작 노드 입력받기
        start = sc.nextInt();

        //최단거리 테이블 및 그래프 초기화
        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        //그래프의 간선 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node1(b, c));
        }

        //다익스트라 최단거리 알고리즘 실행
        dyikstra(start);
    }

}
