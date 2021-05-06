package Chapter11.problem37;

import java.util.*;

class Bus implements Comparable<Bus>{

    private int index;
    private int price;

    public Bus(int index, int price) {
        this.index = index;
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public int getPrice() {
        return price;
    }

    //비용이 적은것 부터 오름차순으로 정렬
    @Override
    public int compareTo(Bus bus) {
        if(this.price < bus.price) return -1;
        else return 1;
    }
}

public class MySourceCode {

    public static final int INF = (int)1e9;
    public static int n, m;
    public static List<List<Bus>> graph = new ArrayList<>();
    public static int[] d;

    public static void dyikstra(int start){
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        //우선순위 큐에 시작위치 삽입
        pq.offer(new Bus(start, 0));
        d[start] = 0;

        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            //큐에서 하나를 꺼낸다
            Bus now = pq.poll();
            int index = now.getIndex();
            int price = now.getPrice();
            //이미 처리된 노드라면 무시한다 -> 이미 처리되었으면 최단거리 테이블이 지금 비용보다 낮을 것
            if(d[index] < price) continue;

            //다익스트라 알고리즘 수행
            //현재의 도시와 연결되어있는 도시들 중 비용이 작은것 부터 수행
            for(int i = 0; i < graph.get(index).size(); i++){
                //출발도시에서 현재도시까지의 비용 + 현재도시와 붙어있는 도시들까지의 비용
                int cost = d[index] + graph.get(index).get(i).getPrice();
                //출발도시에서 현재도시와 불어있는 도시까지의 최단거리보다 더 작게 비용이 나온다면 최단거리 테이블 적용
                if(cost < d[graph.get(index).get(i).getIndex()]){
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Bus(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //도시(노드)의 개수, 버스(간선)의 개수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();

        //최단경로 테이블 초기화
        d = new int[n+1];

        //버스에 대한 정보 입력받기
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a에서 b로 가는 비용이 c
            graph.get(a).add(new Bus(b, c));
        }

        //도시 i 에서 j 로 가는데 필요한 최소비용 출력
        for(int i = 1; i <= n; i++){
            //최단경로 테이블 초기화
            Arrays.fill(d, INF);
            dyikstra(i);
            for(int j = 1; j <= n; j++){
                if(d[j] == INF) System.out.print(0 + " ");
                else System.out.print(d[j] + " ");
            }
            System.out.println();
        }
    }
}
