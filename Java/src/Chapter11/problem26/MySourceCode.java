package Chapter11.problem26;

import java.util.*;

public class MySourceCode {

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            pq.offer(sc.nextInt());
        }

        int sum = 0;
        while(!pq.isEmpty()){
            int compareA = 0;
            int compareB = 0;

            if(result == 0) compareA = pq.poll();
            else compareA = sum;

            if(!pq.isEmpty()) compareB = pq.poll();

            sum = compareA + compareB;
            result += sum;
        }

        System.out.println("result = " + result);
    }
}