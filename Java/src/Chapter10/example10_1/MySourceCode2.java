package Chapter10.example10_1;

import java.util.*;

public class MySourceCode2 {

    public static int[] parent;

    public static int findParent(int x){
        //자기 자신이 부모라면 자기 자신 반환
        if(parent[x] == x) return x;
        //아니라면 자신의 부모를 호출
        else return findParent(parent[x]);
    }

    //두개의 노드를 합치기
    public static void unionParent(int a, int b){

        a = findParent(a);
        b = findParent(b);

        //더 작은 번호의 노드를 부모로 설정
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //노드의 개수와 간선의 개수 입력받기
        int v = sc.nextInt();
        int e = sc.nextInt();
        //그래프 초기화
        parent = new int[v+1];
        //각 노드의 부모를 자기자신으로 초기화
        for(int i = 0; i <= v; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            unionParent(a, b);
        }

        //각 원소가 속한 집합 출력
        System.out.print("각 원소가 속한 집합: ");
        for(int i = 1; i <= v; i++){
            System.out.print(findParent(i) + " ");
        }

        //부모 테이블 출력
        System.out.println();
        System.out.print("부모 테이블: ");
        for(int i = 1; i <= v; i++){
            System.out.print(parent[i] + " ");
        }
    }
}
