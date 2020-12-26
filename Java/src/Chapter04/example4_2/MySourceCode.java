package Chapter04.example4_2;

import java.util.*;

public class MySourceCode {
    public static boolean check(int hour, int minutes, int seconds){
        if(hour / 10 == 3 || hour % 10 == 3 || minutes / 10 == 3 || minutes % 10 == 3 || seconds / 10 == 3 || seconds % 10 == 3){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //시 입력 받기
        int n = scanner.nextInt();

        int result = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < 60; j++){
                for(int k = 0; k < 60; k++){
                    if(check(i,j,k)) result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
