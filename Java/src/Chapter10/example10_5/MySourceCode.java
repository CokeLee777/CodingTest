package Chapter10.example10_5;

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

    public static int v, e;
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

        //노드의 개수와 간선의 개수 입력받기
        v = sc.nextInt();
        e = sc.nextInt();
        // 부모테이블을 자기자신으로 초기화
        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            //노드a, 노드b, 비용 입력받기
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);    //비용이 작은 순으로 정렬

        //비용이 낮은 것 부터 차례대로 확인
        for(int i = 0; i < edges.size(); i++){
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();
            /**
             * 사이클이 발생하지 않은 경우만 포함
             */
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);

    }
}
