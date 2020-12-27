package Chapter05.example5_2;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(5);
        queue.add(2);
        queue.add(3);
        queue.add(7);
        queue.remove();
        queue.add(1);
        queue.add(4);
        queue.remove();

        while(!queue.isEmpty()){
            System.out.println(queue.peek());       //먼저 들어온 순서대로 출력.
            queue.remove();                         //먼저 들어온 순서대로 꺼낸다.
        }

    }
}
