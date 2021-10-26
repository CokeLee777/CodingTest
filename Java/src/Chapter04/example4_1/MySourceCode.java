package Chapter04.example4_1;

import java.util.*;

public class MySourceCode {

    public static int n;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static char[] moveTypes = {'R','L','U','D'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;

        n = sc.nextInt();
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        for (String plan : plans) {
            int nx = -1, ny = -1;
            for(int i = 0; i < moveTypes.length; i++){
                if(plan.charAt(0) == moveTypes[i]){
                    nx = x + dx[i];
                    ny = y + dy[i];
                    break;
                }
            }

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            x = nx;
            y = ny;
        }

        System.out.println((x+1) + " " + (y+1));
    }
}
