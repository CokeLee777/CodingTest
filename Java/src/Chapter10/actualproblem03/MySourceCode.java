package Chapter10.actualproblem03;

import java.util.*;

class Edge implements Comparable<Edge>{

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
    public int compareTo(Edge edge) {
        if(this.distance < edge.distance) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static int n, m;
    public static int[] parent = new int[100001];
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //집의 갯수, 길의 갯수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //부모 정보 자기자신으로 초기화
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        //길의 정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(a, b, cost));
        }
        // 비용이 가장 적은것이 우선으로 정렬
        Collections.sort(edges);
        //가장 비용이 큰 간선
        int maxCost = 0;

        for(int i = 0; i < edges.size(); i++){
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();
            //사이클이 발생하지 않았다면
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += cost;
                maxCost = cost;
            }
        }

        System.out.println(result - maxCost);
    }
}
