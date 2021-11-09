package Chapter10.example10_6;

import java.util.*;

/**
 * 위상정렬
 * 순서가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘
 */
public class MySourceCode {

    public static int v, e;         //노드와 간선의 개수
    public static int[] indegree;   //전입차수
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void topologySort(){

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        //전입 차수가 0인 노드 큐에 삽입
        for(int i = 1; i <= v; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            result.add(now);
            //현재 노드 다음의 과목 전입차수 1씩 뺴기
            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;
                if(indegree[graph.get(now).get(i)] == 0){
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

        for (Integer r : result) {
            System.out.print(r + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //노드와 간선의 개수 입력받기
        v = sc.nextInt();
        e = sc.nextInt();
        //전입차수 배열 초기화
        indegree = new int[v+1];
        //그래프 초기화
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<>());
        }
        //간선 정보 입력받기
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            indegree[b] += 1;
        }


        topologySort();
    }
}
