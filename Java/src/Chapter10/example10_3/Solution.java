package Chapter10.example10_3;

import java.util.*;

public class Solution {

    public static int v, e;
    public static int[] parent = new int[100001];

    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
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

        boolean cycle = false;  //사이클 발생 여부

        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //사이클이 발생한 경우 종료
            if(findParent(a) == findParent(b)){
                cycle = true;
                break;
            } else {
                unionParent(a, b);
            }
        }

        if(cycle){
            System.out.println("사이클 발생 O");
        } else {
            System.out.println("사이클 발생 X");
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
