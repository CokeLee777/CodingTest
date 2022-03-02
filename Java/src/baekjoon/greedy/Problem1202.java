package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem1202 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //n: 보석의 총 개수, k: 상덕이가 가지고있는 가방의 개수
        int n = in.nextInt();
        int k = in.nextInt();
        //다음 n개의 줄에는 보석의 무게m과 가격v가 주어진다
        int[][] box = new int[n][2];
        for(int i = 0; i < n; i++){
            box[i][0] = in.nextInt();
            box[i][1] = in.nextInt();
        }
        //다음 k개의 줄에는 가방마다 최대무게가 주어진다.
        int[] bagWeights = new int[k];
        for(int i = 0; i < k; i++){
            bagWeights[i] = in.nextInt();
        }

        //보석은 무게 오름차순 -> 무게가 같으면 내림차순
        Arrays.sort(box, (o1, o2) -> {
            if(o1[0] < o2[0]) return -1;
            else if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return 1;
        });
        //가방 무게는 낮은 순서대로 정렬
        Arrays.sort(bagWeights);

        //가방에 보석을 하나씩 담는다
        long totalPrice = 0;
        //가격이 높은 순서대로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0, j = 0; i < k; i++){
            //현재 무게보다 낮은 보석들을 집어넣는다
            while(j < n && bagWeights[i] >= box[j][0]){
                pq.offer(box[j++][1]);
            }
            //큐에 값이 있다면 삽입
            if(!pq.isEmpty()){
                totalPrice += pq.poll();
            }
        }

        System.out.println(totalPrice);
    }
}
