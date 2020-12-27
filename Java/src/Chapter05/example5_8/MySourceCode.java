package Chapter05.example5_8;

import java.util.*;

public class MySourceCode {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static boolean[] visited = new boolean[9];

    public static void Dfs(int now){
        //첫 노드 방문처리
        visited[now] = true;
        System.out.print(now + " ");

        for(int i = 0; i < graph.get(now).size(); i++){

            if(!visited[graph.get(now).get(i)]){
                int y = graph.get(now).get(i);
                Dfs(y);
            }

        }
    }

    public static void main(String[] args){

        MySourceCode mySourceCode = new MySourceCode();

        //그래프 틀 구현
        for(int i = 0; i < 9; i++){
            graph.add(new ArrayList<Integer>());
        }
        //그래프 채워넣기
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        Dfs(1);

    }
}
