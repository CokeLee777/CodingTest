package baekjoon.graph;

import java.io.*;
import java.util.*;

public class Problem2623 {

    private static String topologicalSort(List<List<Integer>> graph, int[] indegree){
        Queue<Integer> queue = new LinkedList<>();

        //전입차수가 0인 번호 큐에 삽입
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        //큐가 빌때까지 위상정렬 수행
        StringBuilder results = new StringBuilder();
        int count = 0;
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            results.append(now + "\n");
            count++;
            for(int i = 0; i < graph.get(now).size(); i++){
                if(--indegree[graph.get(now).get(i)] == 0){
                    queue.offer(graph.get(now).get(i));
                }
            }
        }

        return count == indegree.length-1 ? results.toString() : "0\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //가수의 수와 보조PD의 수 입력받기
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        //그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        //전입차수 배열 초기화
        int[] indegree = new int[n+1];

        //각 보조PD가 정한 순서 입력받기
        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");

            for(int j = 1; j < input.length-1; j++){
                int a = Integer.parseInt(input[j]);
                int b = Integer.parseInt(input[j + 1]);

                graph.get(a).add(b);
                indegree[b]++;
            }
        }

        //위상정렬 수행
        String results = topologicalSort(graph, indegree);

        bw.write(results);
        bw.flush();
    }
}
