package Chapter09.actualproblem3;

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
    public static int n, m, c;
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
    public static int[] d;

    public static void dyikstra(int start){
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        //큐에 시작노드 삽입
        pq.offer(new Node2(start, 0));
        //시작노드 거리 0으로 초기화
        d[start] = 0;

        while(!pq.isEmpty()){
            Node2 now = pq.poll();
            int index = now.getIndex();
            int distance = now.getDistance();

            //이미 처리된 노드라면 무시
            if(d[index] < distance) continue;

            //연결된 노드에 관해서 수행
            for(int i = 0; i < graph.get(index).size(); i++){
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
        //노드의 개수, 간선의 개수, 시작노드 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        //최단경로 배열 초기화
        d = new int[n+1];
        Arrays.fill(d, INF);

        //통로에 대한 정보 입력받기
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph.get(x).add(new Node2(y, z));
        }

        dyikstra(c);

        int totalTime = 0;
        int totalCity = 0;

        for(int i = 1; i <= n; i++){
            if(i != c && d[i] != INF){
                totalCity += 1;
                totalTime = Math.max(totalTime, d[i]);
            }
        }

        System.out.println(totalCity + " " + totalTime);
    }
}
