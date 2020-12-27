package Chapter05.example5_6;

public class MySourceCode {
    public static final int INF = 999999999;

    public static void main(String[] args){
        //인접 행렬 방식
        int[][] graph = new int[][]{
                {0,7,5},        //노드 0과 1은 간선 7로 연결되어있는 구조, 노드 0과 노드 2는 간선 5로 연결되어있는 구조
                {7,0,INF},      //노드 0과 1은 간선 7로 연결되어있는 구조, 노드 1과 노드 2는 연결되어있지 않음(INF 로 표현)
                {5,INF,0}       //노드 0과 2는 간선 5로 연결되어있는 구조, 노드 2와 노드 1은 연결되어있지 않음
        };

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
