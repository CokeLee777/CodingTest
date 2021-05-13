package baekjoon.greedy;

import java.util.*;

class Rope implements Comparable<Rope>{

    private int weight;

    public Rope(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Rope rope) {
        if(this.weight < rope.weight) return -1;
        else return 1;
    }
}

public class problem2217 {

    public static int n;
    public static PriorityQueue<Rope> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //로프의 개수 입력받기
        n = sc.nextInt();

        //각 로프가 버틸 수 있는 최대 중량 입력받기
        for(int i = 0; i < n; i++){
            int weight = sc.nextInt();
            pq.offer(new Rope(weight));
        }

        int result = 0;

        while(!pq.isEmpty()){
            //k개의 로프 이용
            int k = pq.size();
            //현재 최소 중량
            Rope now = pq.poll();
            int weight = now.getWeight();
            //들어올릴수 있는 물체의 최대 중량
            int maxResult = weight * k;
            //만약 전의 결과보다 덜 들어올릴 수 있다면 종료
            if(result < maxResult) result = maxResult;
        }

        System.out.print(result);

    }
}
