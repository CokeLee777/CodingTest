package Chapter06.example6_1;

public class MySourceCode {

    public static int[] arr = {7,5,9,0,3,1,6,2,4,8};

    //선택정렬 알고리즘
    public static void main(String[] args) {

        for(int i = 0; i < arr.length; i++){
            int min_index = i;
            for(int j = i+1; j < arr.length; j++){
                //작은 원소의 인덱스 보다 더 작은 인덱스가 존재한다면
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            //스와프
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        for(int a: arr){
            System.out.print(a + " ");
        }
    }
}
