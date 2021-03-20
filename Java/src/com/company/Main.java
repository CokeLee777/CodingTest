package com.company;

import java.util.*;

class Node implements Comparable<Node>{

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }


    @Override
    public int compareTo(Node node) {
        if(this.distance < node.distance) return -1;
        else return 1;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();
        String[] arr = new String[10];
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");



    }
}
