package Chapter06.example6_4;

public class MySourceCode {

    public static int[] arr = {5,7,9,0,3,1,6,2,4,8};

    public static void quickSort(int[] arr, int start, int end){
        //원소가 1개인 경우 종료
        if(start >= end) return;

        int pivot = start;  //피벗은 첫번째 원소
        int left = start + 1;
        int right = end;

        while(left <= right){
            //피벗보다 큰 데이터를 찾을 때까지 반복
            while(left <= end && arr[pivot] > arr[left]) left++;
            //피벗보다 작은 데이터를 찾을 때까지 반복
            while(right > start && arr[pivot] < arr[right]) right--;
            //엇갈렸다면 작은데이터와 피벗의 위치를 바꿈
            if(left > right){
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            //엇갈리지 않았다면 작은 데이터와 큰 데이터의 위치를 바꾼다.
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //분할 후 왼쪽 오른쪽 부분에 대해 반복
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {

        quickSort(arr, 0, arr.length-1);

        for(int a: arr){
            System.out.print(a + " ");
        }
    }
}
