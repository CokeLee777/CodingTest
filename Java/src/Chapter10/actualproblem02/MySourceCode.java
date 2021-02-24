package Chapter10.actualproblem02;

import java.util.*;

public class MySourceCode {

    public static int n, m;
    public static int[] parent = new int[100001];
    public static ArrayList<String> result = new ArrayList<>();    //결과값 저장

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
        //학생 번호 수, 연산 수 입력받기
        n = sc.nextInt();
        m = sc.nextInt();
        //처음에는 학생들 자신의 팀으로 초기화
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }
        //연산 입력받기
        for(int i = 0; i < m; i++){
            int calc = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            //팀 합치기 연산이면 서로소 알고리즘 수행
            if(calc == 0){
                unionParent(a, b);
            } else if(calc == 1) {
                //같은 팀 여부확인
                if(parent[a] == parent[b]){
                    result.add("YES");
                } else {
                    result.add("NO");
                }
            }
        }

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
