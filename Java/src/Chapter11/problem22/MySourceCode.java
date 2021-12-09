package Chapter11.problem22;

import java.util.*;

public class MySourceCode {

    //동서남북 회전까지
    public static final int INF = (int)1e9;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void dfs(int[] left, int[] right, int[][] board){
        int leftX = left[0];
        int leftY = left[1];
        int rightX = right[0];
        int rightY = right[1];

        //거리는 항상 1 차이
        int distance = Math.abs(leftX-rightX) + Math.abs(leftY-rightY);

        for(int i = 0; i < 4; i++){
            int lnx = leftX + dx[i];
            int lny = leftY + dy[i];
            int rnx = rightX + dx[i];
            int rny = rightY + dy[i];

            //
        }


    }

    public static int solution(int[][] board) {
        int answer = 0;

        int[] left = {0,0};
        int[] right = {0,1};

        //벽인 경우 무한대로 설정
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1) board[i][j] = INF;
            }
        }

        dfs(left, right, board);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};

        int answer = solution(board);



        System.out.println("answer = " + answer);
    }
}
