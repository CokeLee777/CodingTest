package baekjoon.greedy;

import java.io.*;

public class Problem10775 {

    private static int[] parent;

    private static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //총 게이트의 수 입력받기
        int G = Integer.parseInt(br.readLine());
        parent = new int[G+1];
        for(int i = 1; i <= G; i++){
            parent[i] = i;
        }

        //비행기의 수 입력받기
        int P = Integer.parseInt(br.readLine());

        //비행기 배치하기
        int cnt = 0;
        for(int i = 0; i < P; i++){
            int now = Integer.parseInt(br.readLine());
            //배치할 게이트가 존재하지 않는다면 종료
            int emptyGate = findParent(now);
            if(emptyGate == 0) break;

            unionParent(emptyGate, emptyGate-1);
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
