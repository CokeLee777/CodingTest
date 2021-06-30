package Chapter06.example6_1;

import java.util.*;

public class MySourceCode2 {

    public static int[] arr = {7,5,9,0,3,1,6,2,4,8};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
