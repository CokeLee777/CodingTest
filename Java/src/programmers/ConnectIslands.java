package programmers;

import java.util.PriorityQueue;

public class ConnectIslands {

    public static class MySourceCode{

        class Edge implements Comparable<Edge>{
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

        private int[] parent;

        private int findParent(int x){
            if(x == parent[x]) return x;
            return parent[x] = findParent(parent[x]);
        }

        private void unionParent(int a, int b){
            a = findParent(a);
            b = findParent(b);

            if(a < b) parent[b] = a;
            else parent[a] = b;
        }

        public int solution(int n, int[][] costs) {
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            //비용이 적은 순서대로 정렬
            for(int[] cost : costs){
                pq.offer(new Edge(cost[0], cost[1], cost[2]));
            }

            //부모 테이블 초기화
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }

            //비용이 적은 순서대로 사이클이 발생하지 않도록 비용을 더함
            int totalCost = 0;
            while(!pq.isEmpty()){
                Edge now = pq.poll();
                int nodeA = now.getNodeA();
                int nodeB = now.getNodeB();
                int cost = now.getCost();

                //사이클이 발생하지 않는다면
                if(findParent(nodeA) != findParent(nodeB)){
                    unionParent(nodeA, nodeB);
                    totalCost += cost;
                }
            }

            return totalCost;
        }
    }
}
