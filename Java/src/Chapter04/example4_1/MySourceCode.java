package Chapter04.example4_1;

import java.util.*;

public class MySourceCode {

    public static int n;
    //상하좌우
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    //결과값의 좌표
    public static int[] result = {1,1};

    public static int[] travel(int[] result, String[] plan){

        //계획서 대로 수행
        for(String p: plan){
            if(p.equals("U")){
                int nx = result[0] + dx[0];
                int ny = result[1] + dy[0];
                //벽을 만난다면 무시
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                else {
                    result[0] = nx;
                    result[1] = ny;
                    continue;
                }
            }
            if(p.equals("D")){
                int nx = result[0] + dx[1];
                int ny = result[1] + dy[1];
                //벽을 만난다면 무시
                if(nx < 0 || nx > n || ny < 0 || ny > n) continue;
                else {
                    result[0] = nx;
                    result[1] = ny;
                    continue;
                }
            }
            if(p.equals("L")){
                int nx = result[0] + dx[2];
                int ny = result[1] + dy[2];
                //벽을 만난다면 무시
                if(nx < 0 || nx > n || ny < 0 || ny > n) continue;
                else {
                    result[0] = nx;
                    result[1] = ny;
                    continue;
                }
            }
            if(p.equals("R")){
                int nx = result[0] + dx[3];
                int ny = result[1] + dy[3];
                //벽을 만난다면 무시
                if(nx < 0 || nx > n || ny < 0 || ny > n) continue;
                else {
                    result[0] = nx;
                    result[1] = ny;
                    continue;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //공간의 크기 입력받기
        sc.nextLine();
        String[] plan = sc.nextLine().split(" ");

        result = travel(MySourceCode.result, plan);

        System.out.println(result[0] + " " + result[1]);
    }
}
