package Chapter10.example10_5;

import java.util.*;

class Edge2 implements Comparable<Edge2>{

    private int NodeA;
    private int NodeB;
    private int distance;

    public Edge2(int nodeA, int nodeB, int distance) {
        NodeA = nodeA;
        NodeB = nodeB;
        this.distance = distance;
    }

    public int getNodeA() {
        return NodeA;
    }

    public void setNodeA(int nodeA) {
        NodeA = nodeA;
    }

    public int getNodeB() {
        return NodeB;
    }

    public void setNodeB(int nodeB) {
        NodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge2 edge) {
        if(this.distance < edge.distance) return -1;
        else return 1;
    }
}

public class MySourceCode2 {

    public static int e, v;
    public static int[] parent;
    public static List<Edge2> edges = new ArrayList<>();

    public static int findParent(int x){
        //부모가 자기자신이라면 반환
        if(parent[x] == x) return x;
        //아니라면 부모 반환
        else return findParent(parent[x]);
    }

    public static void unionParent(int a, int b){

        a = findParent(a);
        b = findParent(b);

        //노드 번호가 작은 것으로 부모로 한다
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //노드의 개수와 간선의 개수 입력받기
        v = sc.nextInt();
        e = sc.nextInt();
        //부모 테이블 초기화
        parent = new int[v+1];
        //부모를 자기자신으로 초기화
        for(int i = 0; i <= v; i++){
            parent[i] = i;
        }

        //노드와 간선, 비용 정보 입력받기
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edges.add(new Edge2(a, b, c));
        }

        Collections.sort(edges);    //비용이 작은 순으로 정렬

        int result = 0;

        for(int i = 0; i < edges.size(); i++){
            int nodeA = edges.get(i).getNodeA();
            int nodeB = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();

            //사이클이 발생하지 않을 경우만 수행
            if(findParent(nodeA) != findParent(nodeB)){
                unionParent(nodeA, nodeB);
                result += cost;
            }
        }

        System.out.println("result = " + result);
    }
}
