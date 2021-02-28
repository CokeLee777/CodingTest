package com.company;

import java.util.*;

class Print implements Comparable<Print>{

    private int index;
    private int priority;

    public Print(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Print print) {
        if(this.priority < print.priority){
            return 1;
        } else {
            return -1;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Print> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();



        pq.offer(new Print(0, 1));
        pq.offer(new Print(1, 1));
        pq.offer(new Print(2, 9));
        pq.offer(new Print(3, 1));
        pq.offer(new Print(4, 1));

        int idx = 0;

        for(int i = 0; i < pq.size(); i++){
            Print now = pq.poll();
            int index = now.getIndex();
            idx = index;
            int priority = now.getPriority();
            if(pq.peek().getPriority() == priority){
                break;
            }
        }

    }
}
