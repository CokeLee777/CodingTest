package baekjoon.graph;

import java.util.*;

public class Problem1005 {

    private static void topologicalSort(List<List<Integer>> course, int[] indegree, int[] timeToBuild, int end){
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[timeToBuild.length];

        //건물의 기본 소요시간은 timeToBuild[i]
        for(int i = 1; i < result.length; i++){
            result[i] = timeToBuild[i];
            //선수과목이 없는 과목부터 먼저 큐에 삽입
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        //건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
        while(!queue.isEmpty()){
            Integer node = queue.poll();

            for(Integer i: course.get(node)){
                //max를 하는 이유는 i번째 건물을 짓기 위해서는 선수건물들을 모두 지어야하기 때문이다
                result[i] = Math.max(result[i], result[node] + timeToBuild[i]);

                if((--indegree[i]) == 0){
                    queue.offer(i);
                }
            }
        }

        System.out.println(result[end]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트케이스의 개수 입력받기
        int t = sc.nextInt();
        //N: 건물의 개수, K 건물간의 건설순서 규칙
        for(int test = 0; test < t; test++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            //각 건물당 건설에 걸리는 시간 입력받기
            int[] timeToBuild = new int[n+1];
            for(int i = 1; i <= n; i++){
                timeToBuild[i] = sc.nextInt();
            }
            //건설순서 입력받기
            int[] indegree = new int[n+1];      //남은 선수과목 개수
            List<List<Integer>> course = new ArrayList<>();
            for(int i = 0; i < n+1; i++){
                course.add(new ArrayList<>());
            }
            for(int i = 0; i < k; i++){
                int prev = sc.nextInt();
                int sub = sc.nextInt();
                course.get(prev).add(sub);
                //선수과목 개수 하나씩 증가
                indegree[sub]++;
            }

            //마지막 건물 번호
            int end = sc.nextInt();

            topologicalSort(course, indegree, timeToBuild, end);
        }
    }
}
