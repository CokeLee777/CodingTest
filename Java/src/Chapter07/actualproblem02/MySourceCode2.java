package Chapter07.actualproblem02;

import java.util.*;

public class MySourceCode2 {

    public static int n, m;
    public static int[] store;
    public static int[] finds;

    public static boolean binarySearch(int start, int end, int target){

        if(start > end) return false;

        int mid = (start + end) / 2;

        if(store[mid] == target) return true;
        else if (store[mid] > target) return binarySearch(start, mid - 1, target);
        else return binarySearch(mid + 1, end, target);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        store = new int[n];
        for(int i = 0; i < n; i++){
            store[i] = sc.nextInt();
        }

        m = sc.nextInt();
        finds = new int[m];
        for(int i = 0; i < m; i++){
            finds[i] = sc.nextInt();
        }

        Arrays.sort(store);
        Arrays.sort(finds);

        for (int find : finds) {
            boolean result = binarySearch(0, n, find);

            if(!result){
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }
    }
}
