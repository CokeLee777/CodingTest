package com.company;

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

public class Main {

    public static final int INF = (int)1e9;
    public static List<List<Node>> graph = new ArrayList<>();   //그래프
    public static int n, m;             //노드와 간선 수
    public static boolean[] visited;    //방문여부
    public static int[] d;              //최단거리 테이블

    public static void dyikstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int index = node.getIndex();
            int distance = node.getDistance();

            //이미 처리되었다면 무시
            if(d[index] < distance) continue;

            //연결된 노드를 탐색
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if(cost < d[graph.get(index).get(i).getIndex()]){   //다른노드를 거쳐서가는 것이 한번에 가는 것보다 거리가 짧다면
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        //방문여부 테이블과 최단거리 테이블 초기화
        visited = new boolean[n+1];
        d = new int[n+1];
        Arrays.fill(d, INF);

        //그래프 초기화
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b, c));
        }

        dyikstra(1);

    }
}
