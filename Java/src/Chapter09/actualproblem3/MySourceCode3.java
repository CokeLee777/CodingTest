package Chapter09.actualproblem3;

import java.util.*;

class Node3 implements Comparable<Node3>{

    private int index;
    private int distance;

    public Node3(int index, int distance) {
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
    public int compareTo(Node3 node) {
        if(this.distance < node.distance) return -1;
        else return 1;
    }
}

public class MySourceCode3 {

    public static final int INF = (int)1e9;
    public static int n, m, c;  //노드의 개수, 간선의 개수, 출발지
    public static boolean[] visited;
    public static List<List<Node3>> graph = new ArrayList<>();
    public static int[] d;

    public static void dyikstra(int start){
        PriorityQueue<Node3> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node3(start, 0));

        while(!pq.isEmpty()){
            Node3 node = pq.poll();
            int index = node.getIndex();
            int distance = node.getDistance();

            if(d[index] < distance) continue;

            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node3(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        //그래프 초기화
        visited = new boolean[n+1];

        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph.get(x).add(new Node3(y, z));
        }

        dyikstra(c);

        int count = 0;
        int time = 0;

        for(int i = 0; i < graph.size(); i++){
            for(int j = 0; j < graph.get(i).size(); j++){
                if(graph.get(i).get(j).getDistance() != INF){
                    count += 1;
                    time = Math.max(time, d[graph.get(i).get(j).getIndex()]);
                }
            }
        }

        System.out.println(count + " " + time);
    }
}
