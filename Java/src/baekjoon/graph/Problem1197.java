package baekjoon.graph;

import java.io.*;
import java.util.PriorityQueue;

public class Problem1197 {

    static class Edge implements Comparable<Edge>{
        private int nodeA;
        private int nodeB;
        private int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static int[] parent;

    private static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //노드와 간선의 개수 입력받기
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        //부모 테이블 초기화
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        //간선 정보 입력받기
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            pq.offer(new Edge(a, b, cost));
        }

        //최소 스패닝 트리 구하기
        int totalCost = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int nodeA = now.getNodeA();
            int nodeB = now.getNodeB();
            int cost = now.getCost();
            //사이클이 발생하지 않았다면
            if(findParent(nodeA) != findParent(nodeB)){
                unionParent(nodeA, nodeB);
                totalCost += cost;
            }
        }

        bw.write(totalCost + "\n");
        bw.flush();
    }
}
