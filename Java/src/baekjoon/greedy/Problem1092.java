package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Problem1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //크레인의 개수와 각 크레인의 무게제한 입력받기
        int n = Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            crane.add(Integer.parseInt(input[i]));
        }

        //상자의 개수와 상자의 무게 입력받기
        int m = Integer.parseInt(br.readLine());

        List<Integer> box = new ArrayList<>();
        input = br.readLine().split(" ");
        for(int i = 0; i < m; i++){
            box.add(Integer.parseInt(input[i]));
        }

        //크레인과 박스를 무거운 순서대로 정렬
        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        //제일 무거운 크레인이 제일 무거운 박스를 못든다면 종료
        if (box.get(0) > crane.get(0)) {
            bw.write(-1 + "\n");
            bw.flush();
            return;
        }

        int totalTime = 0;
        while(!box.isEmpty()){
            int idx = 0;
            for(int i = 0; i < crane.size(); i++) {
                if (!box.isEmpty()) {
                    if(idx >= box.size()) break;
                    //현재 크레인이 현재 상자를 못든다면
                    if(box.get(idx) > crane.get(i)) {
                        idx++; i--;
                    } else {
                        box.remove(idx);
                    }
                }
            }
            totalTime++;
        }

        bw.write(totalTime + "\n");
        bw.flush();
    }
}
