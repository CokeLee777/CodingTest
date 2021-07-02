package Chapter09.example9_2;

import java.util.*;

class Node2 implements Comparable<Node2>{

    private int index;
    private int distance;

    public Node2(int index, int distance) {
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
    public int compareTo(Node2 node2) {
        if(this.distance < node2.distance) return -1;
        else return 1;
    }
}

public class MySourceCode2 {

    public static final int INF = (int)1e9;
    public static int n, m, start;

    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
    public static int[] d;

    //다익스트라 최단경로 알고리즘 수행
    public static void dyikstra(int start){
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        //시작노드에서 시작노드로 가는 비용은 0
        d[start] = 0;

        //큐에 시작노드 삽입
        pq.offer(new Node2(start, 0));

        while(!pq.isEmpty()){
            Node2 now = pq.poll();
            int index = now.getIndex();
            int distance = now.getDistance();

            //이미 처리된 노드라면 무시
            if(d[index] < distance) continue;

            for(int i = 0; i < graph.get(index).size(); i++){
                //index 노드와 연결되어있는 노드 중에 index를 거쳐서 가는 비용
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node2(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //노드와 간선의 개수, 시작 노드 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 입력받기
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int distance = sc.nextInt();

            graph.get(a).add(new Node2(b, distance));
        }

        d = new int[n+1];
        Arrays.fill(d, INF);

        dyikstra(start);

        for(int i = 1; i <= n; i++){
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }
}
