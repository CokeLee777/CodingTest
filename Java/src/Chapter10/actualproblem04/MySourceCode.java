package Chapter10.actualproblem04;

import java.util.*;

public class MySourceCode {

    public static int n;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] indegree;
    public static int[] times;

    public static void topologySort(){
        int[] results = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();

        //결과를 담을 배열
        for(int i = 1; i <= n; i++){
            results[i] = times[i];
        }

        //선수과목이 없는 강의 큐에 삽입
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            Integer now = queue.poll();

            for(int i = 0; i < graph.get(now).size(); i++){
                indegree[graph.get(now).get(i)] -= 1;
                results[graph.get(now).get(i)] = Math.max(results[graph.get(now).get(i)], results[now] + times[graph.get(now).get(i)]);
                if(indegree[graph.get(now).get(i)] == 0){
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

        for(int i = 1; i <= n; i++){
            System.out.println(results[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //강의 개수
        n = sc.nextInt();

        //배열 초기화
        indegree = new int[n+1];
        times = new int[n+1];

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++){

            int time = sc.nextInt();
            times[i] = time;

            while(true){
                int input = sc.nextInt();   //선수과목 입력받기
                if(input == -1) break;      //없으면 종료
                else {
                    graph.get(input).add(i);    //강의 i 의 선수과목은 input
                    indegree[i] += 1;           //선수과목 1 증가
                }
            }
        }

        topologySort();

    }
}
