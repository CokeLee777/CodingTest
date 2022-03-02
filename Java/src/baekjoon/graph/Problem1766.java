package baekjoon.graph;

import java.util.*;

public class Problem1766 {

    private static List<List<Integer>> graph = new ArrayList<>();

    private static void topologicalSort(int[] indegree){
        //우선순위큐로 하는 이유는 풀 수 있는 무제가 여러개면 쉬운 문제부터 풀어야하기 때문이다
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> orders = new ArrayList<>();

        //전입차수가 0인것 큐에 삽입
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0) pq.offer(i);
        }

        //큐가 빌때까지 반복
        while(!pq.isEmpty()){
            Integer node = pq.poll();
            //현재 노드 순서에 삽입
            orders.add(node);
            //현재 문제를 풀고 전입차수가 0이되는 것이 있다면 삽입
            for(int i = 0; i < graph.get(node).size(); i++){
                if((--indegree[graph.get(node).get(i)]) == 0){
                    pq.offer(graph.get(node).get(i));
                }
            }
        }

        //정답 출력
        for (Integer order : orders) {
            System.out.print(order + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //문제의 수와 먼저 푸는것이 좋은 문제에 대한 정보의 개수 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        //정보들 입력받기
        int[] indegree = new int[n+1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //a에서 b로 연결
            graph.get(a).add(b);
            //b의 전입차수 증가
            indegree[b]++;
        }

        topologicalSort(indegree);
    }
}
