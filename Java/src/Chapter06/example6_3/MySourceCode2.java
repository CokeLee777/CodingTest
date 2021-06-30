package Chapter06.example6_3;

import java.util.*;

public class MySourceCode2 {

    public static int[] arr = {7,5,9,0,3,1,6,2,4,8};

    public static void main(String[] args) {

        for(int i = 1; i < arr.length; i++){
            int switchIndex = i;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] > arr[switchIndex]){
                    int temp = arr[switchIndex];
                    arr[switchIndex] = arr[j];
                    arr[j] = temp;
                    switchIndex = j;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
