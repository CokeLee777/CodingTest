package baekjoon.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem1647 {

    static class Edge implements Comparable<Edge>{
        private int nodeA;
        private int nodeB;
        private int distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance - e.distance;
        }
    }

    private static int[] parent;

    private static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b){
        //부모를 찾는다
        a = findParent(a);
        b = findParent(b);
        //원소가 작은 노드로 초기화
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //집의 개수, 길의 개수 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        //길의 정보 입력받기
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            //a에서 b로가는 비용이 cost라는 뜻
            edges.add(new Edge(a, b, cost));
        }

        //비용이 작은 순서대로 정렬
        Collections.sort(edges);

        //부모 테이블 초기화 -> 자기자신으로 부모를 초기화
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        //비용이 낮은 것 부터 확인
        int totalPrice = 0; int max = 0;
        for(int i = 0; i < edges.size(); i++){
            Edge edge = edges.get(i);
            int a = edge.getNodeA();
            int b = edge.getNodeB();
            int cost = edge.getDistance();
            //사이클이 발생하지 않았다면 두 원소의 부모를 합친다
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                totalPrice += cost;
                max = cost;
            }
        }

        //가장 비용이 큰 도로의 비용을 빼주면서 두 개의 마을로 분리한다
        System.out.println(totalPrice - max);
    }
}
