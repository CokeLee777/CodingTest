package programmers;

import java.util.*;

public class CheckDistance {

    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static boolean checkP(String[] place, int x, int y){

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //벽이거나 파티션인 경우 무시
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || place[nx].charAt(ny) == 'X') continue;

            //상하좌우에 P 가 있으면 true
            if(place[nx].charAt(ny) == 'P') return true;
        }

        return false;
    }

    public static boolean checkO(String[] place, int x, int y, int pCount){

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //벽이거나 파티션인 경우 무시
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || place[nx].charAt(ny) == 'X') continue;

            //상하좌우에 P가 있으면 카운트 증가
            if(place[nx].charAt(ny) == 'P') pCount++;
        }

        return pCount >= 2;
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        Arrays.fill(answer, 1);

        int index = 0;

        for(String[] place: places){
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    boolean checkP = false;
                    boolean checkO = false;
                    if(place[i].charAt(j) == 'P'){
                        checkP = checkP(place, i, j);
                    }
                    if(place[i].charAt(j) == 'O'){
                        checkO = checkO(place, i, j, 0);
                    }
                    //거리두기를 지키지 않았다면
                    if(checkP || checkO) {
                        answer[index] = 0;
                        break;
                    }
                }
                if(answer[index] == 0) break;
            }

            index += 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        String[][] places = {
                {"OOOPX", "XPOOP", "OOOXO", "OXOPX", "OPOOP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOOP", "XPOOX", "OOOXO", "OXOPX", "OPOOP"},
                {"POPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] answer = solution(places);

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
