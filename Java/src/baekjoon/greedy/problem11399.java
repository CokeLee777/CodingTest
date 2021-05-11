package baekjoon.greedy;

import java.util.*;

public class problem11399 {

    public static int n;
    public static int[] people;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //사람의 수 입력받기
        n = sc.nextInt();
        people = new int[n];

        //각 사람이 돈을 인출하는데 필요한 시간 입력받기
        for(int i = 0; i < n; i++){
            int time = sc.nextInt();
            people[i] = time;
        }

        //리스트 정렬
        Arrays.sort(people);

        //각 사람이 돈을 인출하는데 필요한 시간의 최소값 구하기
        int result = 0;
        int now = 0;
        for(int i = 0; i < n; i++){
            now += people[i];
            result += now;
        }

        System.out.println(result);
    }
}
