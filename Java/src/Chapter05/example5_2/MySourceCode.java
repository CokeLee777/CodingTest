package Chapter05.example5_2;

import java.util.*;

public class MySourceCode {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); //큐가 꽉 찼을 때 더이상 추가 못하면 false 리턴, 아니면 true 리턴
        queue.add(5);       //큐가 꽉 찼을 때 예외 발생
        queue.add(2);
        queue.add(3);
        queue.add(7);
        queue.remove();     //큐가 비었을 때 꺼내려고 하면 예외 발생
        queue.poll();       //큐가 비었을 때 꺼내려고 하면 null 리턴
        queue.add(1);
        queue.add(4);
        queue.remove();

        while(!queue.isEmpty()){
            System.out.println(queue.peek());       //먼저 들어온 순서대로 출력.
            queue.remove();                         //먼저 들어온 순서대로 꺼낸다.
        }

        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }
}
