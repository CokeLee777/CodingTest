package Chapter11.problem41;

import java.util.Scanner;

public class MySourceCode {

    public static int n, m;
    public static int[] parent;
    public static int[][] graph;

    public static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        parent = new int[n+1];
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int now = sc.nextInt();
                if(now == 1){
                    union(i+1, j+1);
                }
            }
        }

        int prev = 0;
        for(int i = 0; i < m; i++){
            int route = sc.nextInt();
            if(prev == 0) {
                prev = parent[route];
                continue;
            }

            if(prev != parent[route]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
