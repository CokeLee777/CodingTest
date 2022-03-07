package baekjoon.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem2252 {

    private static String topologicalSort(int[] indegree, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();

        //전입차수가 0인 학생 큐에삽입
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        //큐가 빌때까지 위상정렬 실행
        StringBuilder results = new StringBuilder();
        while(!queue.isEmpty()){
            Integer stdNum = queue.poll();
            results.append(stdNum).append(" ");

            for(int i = 0; i < graph.get(stdNum).size(); i++){
                if(--indegree[graph.get(stdNum).get(i)] == 0){
                    queue.offer(graph.get(stdNum).get(i));
                }
            }
        }

        return results.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //학생의 수와 비교한 횟수 입력받기
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        //전입차수 배열과 그래프 초기화
        int[] indegree = new int[N+1];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        //비교한 학생들 입력받기
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            indegree[b]++;
        }

        //위상정렬 실행
        String results = topologicalSort(indegree, graph);

        bw.write(results);
        bw.flush();
    }
}
