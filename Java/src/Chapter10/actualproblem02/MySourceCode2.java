package Chapter10.actualproblem02;

import java.util.*;

public class MySourceCode2 {

    public static int n, m;     //팀의 개수(N+1), 연산횟수
    public static int[] parent;
    public static List<String> results = new ArrayList<>();

    public static void unionParent(int a, int b){

        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        else return findParent(parent[x]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        //자기자신으로 부모 테이블 초기화
        parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        //연산 입력받기
        for(int i = 0; i < m; i++){
            int cal = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(cal == 0){
                unionParent(a ,b);
                continue;
            }

            if(cal == 1){
                if(findParent(a) == findParent(b)) results.add("YES");
                else results.add("NO");
            }

        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}
