package Chapter11.problem40;

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

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node node) {
        if(this.distance < node.distance) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static int n, m;
    public static List<List<Node>> graph = new ArrayList<>();
    public static int[] d;

    public static void dyikstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작노드 우선순위 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;

        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            //현재 노드정보 꺼내기
            Node now = pq.poll();
            int index = now.getIndex();
            int distance = now.getDistance();

            //이미 가본 노드라면 무시
            if(d[index] < distance) continue;

            //다익스트라 알고리즘 수행
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //헛간(노드)의 개수와 통로(간선)의 개수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();

        //그래프 초기화
        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a, 1));
        }

        dyikstra(1);


        //최단거리가 가장 큰 노드, 그 헛간까지의 거리, 그 헛간과 같은 거리를 갖는 헛간의 개수 출력
        int maxNode = 1;
        int maxDistance = 0;
        int cnt = 0;
        for(int x = 1; x < n; x++){
            // 최단거리가 더 크다면
            if(d[x] < d[x+1]){
                maxNode = x+1;
                maxDistance = d[x+1];
            }
        }

        for(int x = 1; x <= n; x++){
            if(d[x] == maxDistance) cnt += 1;
        }

        System.out.println(maxNode + " " + maxDistance + " " + cnt);
    }
}
