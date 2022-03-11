package baekjoon.graph;

import java.io.*;
import java.util.*;

public class Problem1948 {

    static class Node{
        private int index;
        private int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }
    }

    private static int n, m, start, end;
    private static int[] time;
    private static int[] indegree;
    private static List<List<Node>> matrix = new ArrayList<>();
    private static List<List<Node>> inverseMatrix = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //도시의 개수와 도로의 개수 입력받기
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //그래프 초기화
        for(int i = 0; i <= n; i++){
            matrix.add(new ArrayList<>());
            inverseMatrix.add(new ArrayList<>());
        }

        //도로 정보 입력받기
        time = new int[n+1];
        indegree = new int[n+1];

        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);

            matrix.get(a).add(new Node(b, time));
            inverseMatrix.get(b).add(new Node(a, time));
            indegree[b]++;
        }

        //출발도시 도착도시 입력받기
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        //출발도시만 큐에 삽입
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        //모두 만나는 시간 구하기
        while(!queue.isEmpty()){
            Integer now = queue.poll();

            for(int i = 0; i < matrix.get(now).size(); i++){
                //다음 길
                Node node = matrix.get(now).get(i);
                int nextNode = node.getIndex();

                //시간 비교
                time[nextNode] = Math.max(time[now] + node.getTime(), time[nextNode]);

                //전입차수가 0이라면 삽입
                if(--indegree[nextNode] == 0){
                    queue.offer(nextNode);
                }

            }
        }

        //1분도 쉬지않고 달려야 하는 도로의 수 구하기
        int road = 0;
        boolean[] visited = new boolean[n+1];
        queue = new LinkedList<>();
        queue.offer(end);
        while(!queue.isEmpty()){
            Integer now = queue.poll();
            //이미 방문한 노드라면 무시
            if(visited[now]) continue;
            //방문처리
            visited[now] = true;

            for(int i = 0; i < inverseMatrix.get(now).size(); i++){
                Node nextNode = inverseMatrix.get(now).get(i);
                if(time[now] - nextNode.getTime() == time[nextNode.getIndex()]){
                    road++;
                    queue.offer(nextNode.getIndex());
                }
            }
        }

        bw.write(time[end] + "\n" + road);
        bw.flush();
    }
}
