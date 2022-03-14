package baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Problem1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트케이스의 개수 입력받기
        int test = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        for(int t = 0; t < test; t++){
            //지원자의 수 입력받기
            int n = Integer.parseInt(br.readLine());
            //각 지원자의 서류심사 순위, 면접성적 순위 입력받기
            int[][] people = new int[n][2];
            for(int i = 0; i < n; i++){
                String[] input = br.readLine().split(" ");

                people[i][0] = Integer.parseInt(input[0]);
                people[i][1] = Integer.parseInt(input[1]);
            }
            //서류심사 순위로 정렬
            Arrays.sort(people, Comparator.comparingInt(p -> p[0]));

            //면접심사 순위에 따라 신입사원 인원수 계산
            int minRank = people[0][1];
            int cnt = 1;
            for(int i = 0; i < people.length; i++){
                int rank = people[i][1];
                if(rank < minRank){
                    minRank = rank;
                    cnt++;
                }
            }

            ans.append(cnt).append("\n");
        }

        bw.write(ans.toString());
        bw.flush();
    }
}
