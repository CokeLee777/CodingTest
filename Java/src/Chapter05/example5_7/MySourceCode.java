package Chapter05.example5_7;

import java.util.*;

class Node{
    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public void show(){
        System.out.println("노드 : " + this.index + " 거리 : " + this.distance);
    }

}

public class MySourceCode {
    //ArrayList<Node>형 ArrayList 객체를 만든다.
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args){
        //인접 리스트 방식
        for(int i = 0; i < 3; i++){
            graph.add(new ArrayList<Node>());   //행을 3개 만든다.
        }
        //Node 0 에 연결된 Node와 간선 입력
        graph.get(0).add(new Node(1,7));
        graph.get(0).add(new Node(2,5));
        //Node 1에 연결된 Node 와 간선 입력
        graph.get(1).add(new Node(0,7));
        //Node 2에 연결된 Node 와 간선 입력
        graph.get(2).add(new Node(0,5));

        for(int i = 0;i < 3; i++){
            for(int j = 0; j < graph.get(i).size(); j++){
                graph.get(i).get(j).show();
            }
        }

    }
}
