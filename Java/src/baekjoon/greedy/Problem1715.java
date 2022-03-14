package baekjoon.greedy;

import java.io.*;
import java.util.PriorityQueue;

public class Problem1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //카드 묶음의 수 입력받기
        int n = Integer.parseInt(br.readLine());
        //각각의 카드 묶음의 크기 입력받기
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            cards.offer(Integer.parseInt(br.readLine()));
        }

        //카드묶음을 2개씩 합친다
        int total = 0;
        while(!cards.isEmpty()){
            Integer first = cards.poll();
            if(!cards.isEmpty()){
                Integer second = cards.poll();

                total += (first + second);
                cards.offer(first + second);
            }
        }

        bw.write(total + "\n");
        bw.flush();
    }
}
