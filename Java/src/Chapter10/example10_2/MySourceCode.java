package Chapter10.example10_2;

import java.util.*;

public class MySourceCode {

    public static int v, e; //노드의 갯수와 간선의 갯수
    public static int[] parent = new int[100001];   //부모 테이블 생성

    //특정 원소가 속한 집합을 찾기
    public static int findParent(int x){
        //자기 자신이 부모라면 자기자신 반환
        if(x == parent[x]) return x;
        //아니라면 자신의 부모를 호출
        return parent[x] = findParent(parent[x]);
    }

    //두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        //자신보다 작은 요소를 부모로 설정
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드의 갯수와 간선의 갯수 입력받기
        v = sc.nextInt();
        e = sc.nextInt();
        //부모 테이블에서 부모를 자기 자신으로 초기화
        for(int i = 1; i <= v; i++){
            parent[i] = i;
        }
        //Union 연산을 각각 수행
        for(int i = 0; i < e; i++){
            //연결관계 인력받기
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        //각 원소가 속합 집합 출력
        for(int i = 1; i <= v; i++){
            System.out.print(findParent(i) + " ");
        }
        System.out.println();
        //부모 테이블 출력
        for(int i = 1; i <= v; i++){
            System.out.print(parent[i] + " ");
        }

    }
}
