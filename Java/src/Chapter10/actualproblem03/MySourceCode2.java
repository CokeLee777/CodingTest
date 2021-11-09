package Chapter10.actualproblem03;

import java.util.*;

class Edge2 implements Comparable<Edge2>{

    private int nodeA;
    private int nodeB;
    private int distance;

    public Edge2(int nodeA, int nodeB, int distance) {
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
    public int compareTo(Edge2 edge) {
        if(this.distance < edge.distance) return -1;
        else return 1;
    }
}

public class MySourceCode2 {

    public static List<Edge2> edges = new ArrayList<>();
    public static int[] parent;
    public static int n, m;

    public static int findParent(int x){
        if(x == parent[x]) return x;
        else return findParent(parent[x]);
    }

    public static void unionParent(int a, int b){

        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 0;
        int last = 0;

        //집의 개수와 간선 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //부모 테이블 초기화
        parent = new int[n+1];
        //부모를 자기자신으로 초기화
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
        //간선 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edges.add(new Edge2(a, b, c));
        }

        Collections.sort(edges);

        for(int i = 0; i < edges.size(); i++){
            int nodeA = edges.get(i).getNodeA();
            int nodeB = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();

            //사이클이 구성되지 않은 경우에만 집합에 포함
            if(findParent(nodeA) != findParent(nodeB)){
                unionParent(nodeA, nodeB);
                result += cost;
                last = cost;
            }
        }

        System.out.println(result-last);

    }
}
