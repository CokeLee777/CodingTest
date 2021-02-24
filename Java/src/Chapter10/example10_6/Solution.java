package Chapter10.example10_6;

import java.util.*;

public class Solution {

    public static int v, e;
    public static int[] indegree = new int[100001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();  //결과값 저장
        Queue<Integer> queue = new LinkedList<>();      //큐 사용

        //전입차수가 0인 노드 큐에 저장
        for(int i = 1; i <= v; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            result.add(now);

            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;
                if(indegree[graph.get(now).get(i)] == 0){
                    queue.offer(graph.get(now).get(i));
                }
            }
        }
        //결과 출력
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //노드의 갯수, 간선의 갯수 입력받기
        v = sc.nextInt();
        e = sc.nextInt();

        //그래프 초기화
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<>());
        }
        //그래프 입력받기
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);    //노드a 에서 b로 연결
            //전입차수 1 증가
            indegree[b] += 1;
        }

        topologySort();
    }

}
