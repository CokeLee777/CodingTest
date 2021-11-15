package Chapter11.problem15;

import java.util.*;

class Node{

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
}

public class MySourceCode3 {

    public static int n, m, k, x;   //도시의 개수, 도로 개수, 최단거리가 k 인 도시 사이, 출발도시
    public static int[] d;          //최단거리 테이블
    public static final int INF = (int)1e9; //무한대
    public static List<List<Node>> graph = new ArrayList<>();

    public static void dyikstra(int start){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));

        d[start] = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int index = now.getIndex();
            int distance = now.getDistance();

            //이미 처리된 노드라면 무시
            if(d[index] < distance) continue;
            //현재 노드와 연결된 노드들 탐색
            for(int i = 0; i < graph.get(index).size(); i++){
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    queue.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        //도로 정보 입력받기
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(new Node(b,1));
        }

        //최단거리 테이블 초기화
        d = new int[n+1];
        Arrays.fill(d, INF);

        dyikstra(x);

        boolean check = false;
        for(int i = 1; i <= n; i++){
            if(d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if(!check) System.out.println(-1);
    }
}
