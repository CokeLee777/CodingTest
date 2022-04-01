package baekjoon.greedy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Problem9576 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 케이스의 수 입력받기
        int test = sc.nextInt();

        //테스트 실행
        StringBuilder ans = new StringBuilder();
        for(int t = 0; t < test; t++){
            //책의 개수와 학생의 수 입력받기
            int n = sc.nextInt();
            int m = sc.nextInt();

            //학생이 원하는 책의 범위 입력받기
            int[][] studentInfo = new int[m][2];
            for(int i = 0; i < m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                studentInfo[i][0] = a;
                studentInfo[i][1] = b;
            }

            //책의 상한선이 큰 학생부터 정렬
            Arrays.sort(studentInfo, (o1, o2) -> {
                if(o1[1] < o2[1]) return -1;
                else if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return 1;
            });

            //책 번호를 줄여가면서 탐색
            int result = 0;
            boolean[] isGone = new boolean[n+1];
            for(int[] info: studentInfo){
                int a = info[0];
                int b = info[1];

                for(int i = a; i <= b; i++){
                    if(!isGone[i]){
                        isGone[i] = true;
                        result++;
                        break;
                    }
                }
            }

            ans.append(result).append("\n");
        }

        bw.write(ans.toString());
        bw.flush();
    }
}
