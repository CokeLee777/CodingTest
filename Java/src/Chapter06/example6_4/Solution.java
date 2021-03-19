package Chapter06.example6_4;

public class Solution {

    public static int[] arr = new int[]{5,7,9,0,3,1,6,2,4,8};

    public static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            //피벗보다 큰 데이터를 찾을 때 까지 반복
            while(left <= end && arr[left] <= arr[pivot]) left++;
            //피벗보다 작은 데이터를 찾을 때 까지 반복
            while(right > start && arr[right] >= arr[pivot]) right--;
            //엇갈렸다면 작은 데이터와 피벗을 교체한다.
            if(left > right){
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            //엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체한다.
            else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        //분할 후 왼쪽과 오른쪽에서 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);

    }

    public static void main(String[] args) {

        quickSort(arr, 0, arr.length - 1);

        for(int data: arr) System.out.print(data + " ");

    }
}
