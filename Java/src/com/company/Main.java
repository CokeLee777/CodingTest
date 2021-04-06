package com.company;

import java.util.*;

public class Main {

    public static ArrayList<String> answers = new ArrayList<>();
    public static ArrayList<Integer> courseList = new ArrayList<>();
    public static String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    public static int[] course = new int[]{2,3,4};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] solution = solution(orders, course);

        Arrays.sort(solution);

        for(String s: solution){
            System.out.print(s + " ");
        }
    }

    public static String[] solution(String[] orders, int[] course) {

        //주문들 다 정렬
        for (int i = 0; i < orders.length; i++) {
            String str = orders[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }

        //course 리스트에 넣기
        for (int c : course) {
            courseList.add(c);
        }

        for (int i = 0; i < orders.length; i++) {
            String prev = orders[i];
            for (int j = i + 1; j < orders.length; j++) {
                //공통된 요소
                String common = "";
                //비교대상의 String 값을 하나씩 비교
                for (int k = 0; k < orders[j].length(); k++) {
                    String now = orders[j].substring(k, k + 1);
                    //만약 공통된 값이 있다면 추가
                    if (prev.contains(now)) common += now;
                }
                //course와 비교
                if (!courseList.contains(common.length())) continue;
                //answer에 이미있는값인지 비교
                if (answers.contains(common)) continue;
                else {
                    answers.add(common);
                }
            }
        }

        String[] answer = new String[answers.size()];
        for(int i = 0; i < answers.size(); i++){
            answer[i] = answers.get(i);
        }

        return answer;
    }
}
