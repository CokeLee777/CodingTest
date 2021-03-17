package com.company;

import java.util.*;

public class Main {

    public static ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] clothes = new String[][]{{"hat", "head"}, {"green", "head"}, {"sunglass", "eye"}, {"makeup", "face"}};

        Map<String, Integer> map = new HashMap<>();
        map.put("head", map.getOrDefault("head", 0) + 1);
        map.put("head", map.getOrDefault("head", 0) + 1);
        map.put("eye", map.getOrDefault("eye", 0) + 1);

        System.out.println(map.size());

        for (Integer value : map.values()) {
            System.out.println("value = " + value);
        }

        for (String s : map.keySet()) {
            Integer value = map.get(s);

        }


    }
}
