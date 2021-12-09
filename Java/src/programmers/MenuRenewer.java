package programmers;

import java.util.*;

class Course implements Comparable<Course>{

    private String name;
    private Integer count;

    public Course(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    //카운트가 많은 순으로 정렬
    @Override
    public int compareTo(Course c) {
        if(this.count > c.count) return -1;
        else return 1;
    }
}

public class MenuRenewer {
    public static ArrayList<Integer> courseList = new ArrayList<>();
    public static Map<String, Integer> map;

    public static String[] solution(String[] orders, int[] course) {

        //주문들 다 정렬
        for (int i = 0; i < orders.length; i++) {
            String str = orders[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }

        List<String> orderList = Arrays.asList(orders);

        //course 리스트에 넣기
        for (int c : course) {
            courseList.add(c);
        }

        for(int i = 0; i < orderList.size(); i++){
            String common = "";
        }

        String[] answer = {};

        return answer;
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
        int[] course = {2,3,4};

        solution(orders,course);
    }
}
