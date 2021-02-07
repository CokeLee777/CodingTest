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

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    //오름차순으로 정렬
    @Override
    public int compareTo(Node1 node1) {
        if(this.distance < node1.distance) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
    public static int n, m, start;  //노드의 갯수, 간선의 갯수, 시작위치
    public static int[] d;

    public static void dyikstra(int start){
        PriorityQueue<Node1> queue = new PriorityQueue<>();
        //큐에 시작위치 삽입
        queue.offer(new Node1(start, 0));
        d[start] = 0;
        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Node1 now = queue.poll();
            int index = now.getIndex();
            int distance = now.getDistance();
            //이미 처리된 노드라면 무시한다.
            if(d[index] < distance) continue;
            //다익스트라 알고리즘 수행
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    queue.offer(new Node1(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드의 갯수, 간선의 갯수, 시작위치 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        //그래프 초기화
        d = new int[n + 1];

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node1(b, c));
        }

        Arrays.fill(d, INF);

        dyikstra(start);

        for(int i = 1; i < d.length; i++){
            if(d[i] == INF) System.out.println("INFINITY");
            else System.out.println(d[i]);
        }
    }

}
