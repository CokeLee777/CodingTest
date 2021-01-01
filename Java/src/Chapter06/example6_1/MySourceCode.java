package Chapter06.example6_1;

import java.util.*;

public class MySourceCode {

    public static int[] arr = new int[]{7,5,9,0,3,1,6,2,4,8};

    public static int min_index;

    public static void main(String[] args){

        for(int i = 0; i < arr.length; i++){
            min_index = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[min_index] > arr[j]) min_index = j;
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int data: arr){
            System.out.print(data + " ");
        }

    }
}
