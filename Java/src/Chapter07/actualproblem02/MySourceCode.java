package Chapter07.actualproblem02;

import java.util.*;

public class MySourceCode {

    public static int[] storeMaterial;

    public static int[] clientMaterial;

    public static String binarySearch(int[] arr, int target, int start, int end){
        //해당 물품이 없다면
        if(start > end) return "no";
        //중간 지점
        int mid = (start + end) / 2;

        if(target == arr[mid]) return "yes";
        else if(target > arr[mid]) return binarySearch(arr, target, mid + 1, end);
        else return binarySearch(arr, target, start, mid - 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //총 부품 갯수 입력받기
        int n = sc.nextInt();
        //n개의 부품 번호 입력받기
        storeMaterial = new int[n];
        for(int i = 0; i < n; i++) storeMaterial[i] = sc.nextInt();
        //부품 오름차순으로 정렬
        Arrays.sort(storeMaterial);

        //손님이 요청한 부품의 갯수 입력받기
        int m = sc.nextInt();
        //손님이 요청한 부품 번호 입력받기
        clientMaterial = new int[m];
        for(int i = 0; i < m; i++) clientMaterial[i] = sc.nextInt();

        //이진 탐색 수행
        for(int findMaterial: clientMaterial){
            String result = binarySearch(storeMaterial, findMaterial, 0, n - 1);
            System.out.print(result + " ");
        }

    }

}
