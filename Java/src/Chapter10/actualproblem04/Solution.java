package Chapter10.actualproblem04;

import java.util.*;

public class Solution {

    public static int n;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] times;
    public static int[] indegree = new int[501];

    public static void topologySort(){
        int[] result = new int[501]; //알고리즘 수행 결과를 담을 리스트
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            result[i] = times[i];
        }
        //처음 시작시 전입차수가 0 인 노드만 큐에 넣는다
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            //해당 원소와 연결된 노드들의 전입차수에서 1을 뺀다.
            for(int i = 0; i < graph.get(now).size(); i++){
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                //새롭게 전입차수가 0이 되는 노드를 큐에 삽입한다.
                if(indegree[graph.get(now).get(i)] == 0){
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

        for(int i = 1; i <= n; i++){
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //강의의 갯수 입력받기
        n = sc.nextInt();
        times = new int[n+1];
        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        //모든 간선 정보 입력받기
        for(int i = 1; i <= n; i++){
            //강의 시간 정보 입력받기
            int x = sc.nextInt();
            times[i] = x;
            //먼저 들어야하는 강의번호 입력받기
            while(true){
                x = sc.nextInt();
                if(x == -1) break;
                indegree[i] += 1;
                //선수강의 그래프에 추가
                graph.get(x).add(i);
            }
        }

        topologySort();
    }
}
