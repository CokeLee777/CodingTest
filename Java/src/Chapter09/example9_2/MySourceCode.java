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

    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
    public static int[] d;

    public static void dyikstra(int start){
        PriorityQueue<Node1> pq = new PriorityQueue<>();

        //시작노드로 가는 비용은 0
        d[start] = 0;
        //시작노드 큐에 삽입
        pq.offer(new Node1(start, 0));

        //다익스트라 최단경로 알고리즘 수행
        while(!pq.isEmpty()){
            Node1 now = pq.poll();
            int index = now.getIndex();
            int distance = now.getDistance();

            //이미 처리된 노드라면 무시 - 해당 노드가 INF가 아니라면 무시
            if(d[index] < distance) continue;

            //현재 노드와 붙어있는 노드에 대해 다익스트라 최단경로 알고리즘 수행
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
        //노드의 개수 간선의 개수, 시작 노드번호 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 입력받기
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int distance = sc.nextInt();

            graph.get(a).add(new Node1(b,distance));
        }

        //최단거리 테이블 초기화
        d = new int[n+1];
        Arrays.fill(d, INF);

        dyikstra(start);

        for (int i = 1; i < n+1; i++) {
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }

}
