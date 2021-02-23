package Chapter09.actualproblem3;

import java.util.*;

class Node implements Comparable<Node>{

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

    @Override
    public int compareTo(Node node) {
        if(this.distance < node.distance) return -1;
        else return 1;
    }

}

public class MySourceCode {

    public static int[] d = new int[30001]; //최단경로 테이블
    public static final int INF = (int)1e9; //무한
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int n, m, c;  //노드갯수, 간선갯수, 목적지노드번호

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //출발지 초기화
        d[start] = 0;
        pq.offer(new Node(start, 0));
        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int index = now.getIndex();
            int distance = now.getDistance();
            //이미 처리된 적 있다면 무시
            if(d[index] < distance) continue;
            //다익스트라 알고리즘 수행
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = d[index] + graph.get(index).get(i).getDistance();
                //거리가 더 짧은 경우
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //도시의 갯수, 통로의 갯수, 목적지 도시 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            //x에서 y까지의 시간이 z라는 뜻
            graph.get(x).add(new Node(y, z));
        }
        //최단경로 테이블 INF으로 초기화
        Arrays.fill(d, INF);

        dijkstra(c);

        int count = 0;
        int maxDistance = 0;

        for(int i = 1; i <= n; i++){
            if(d[i] != INF){
                count += 1;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println((count - 1) + " " + maxDistance);
    }
}
