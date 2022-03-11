package baekjoon.graph;

import java.io.*;
import java.util.*;

public class Problem2887 {

    private static int n;
    private static int[] parent;

    static class Point{
        private int index;
        private int x;
        private int y;
        private int z;

        public Point(int index, int x, int y, int z) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int getIndex() {
            return index;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }
    }

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

        //행성의 개수 입력받기
        n = Integer.parseInt(br.readLine());
        //부모 테이블 초기화
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        //행성의 좌표 입력받기
        Point[] planet = new Point[n];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");

            for(int j = 0; j < 3; j++){
                planet[i] = new Point(i, Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        //x좌표로 정렬후 비용이 작은 순서대로 노드들 삽입
        Arrays.sort(planet, Comparator.comparingInt(o -> o.x));
        for(int i = 0; i < planet.length-1; i++){
            pq.offer(new Edge(planet[i].index, planet[i+1].index, Math.abs(planet[i].x - planet[i+1].x)));
        }

        //y좌표로 정렬후 비용이 작은 순서대로 노드들 삽입
        Arrays.sort(planet, Comparator.comparingInt(o -> o.y));
        for(int i = 0; i < planet.length-1; i++){
            pq.offer(new Edge(planet[i].index, planet[i+1].index, Math.abs(planet[i].y - planet[i+1].y)));
        }

        //z좌표로 정렬후 비용이 작은 순서대로 노드들 삽입
        Arrays.sort(planet, Comparator.comparingInt(o -> o.z));
        for(int i = 0; i < planet.length-1; i++){
            pq.offer(new Edge(planet[i].index, planet[i+1].index, Math.abs(planet[i].z - planet[i+1].z)));
        }

        int totalCost = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int nodeA = now.getNodeA();
            int nodeB = now.getNodeB();
            int cost = now.getCost();
            //사이클이 발생하지 않는다면 삽입
            if(findParent(nodeA) != findParent(nodeB)){
                unionParent(nodeA, nodeB);
                totalCost += cost;
            }
        }

        bw.write(totalCost + "\n");
        bw.flush();
    }
}
