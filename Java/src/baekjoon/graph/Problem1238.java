package baekjoon.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1238 {

    static class Node implements Comparable<Node>{

        private int index;
        private int distance;

        public Node(int index, int distance) {
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
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    private static List<List<Node>> graph = new ArrayList<>();
    private static int[][] d;

    private static final int INF = (int)1e9;

    public static void dyikstra(int start, int[] d){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작위치 삽입
        pq.offer(new Node(start, 0));
        //자기자신으로가는 길 0으로 초기화
        d[start] = 0;
        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.getIndex();
            int distance = node.getDistance();

            //이미 처리된 노드라면 무시
            if(d[now] < distance) continue;

            //현재 노드와 연결되어있는 노드 방문
            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //마을의 수와 간선의 개수 및 목적지 입력받기
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        //간선 입력받기
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);
            //단방향 이동 가능
            graph.get(a).add(new Node(b, distance));
        }

        //최단거리 테이블 초기화
        d = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(d[i], INF);
        }

        //마을 하나씩 출발지점으로 두고 다익스트라 알고리즘 수행
        for(int i = 1; i <= n; i++){
            dyikstra(i, d[i]);
        }

        //목적지까지 왕복거리중 짧은거리 구하기
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            max = Math.max(d[i][x] + d[x][i], max);
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
