package Chapter06.actualproblem03;

import java.util.*;

class Student implements Comparable<Student>{

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        if(this.score < other.score){
            return -1;
        }
        else{
            return 1;
        }
    }

}

public class MySourceCode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //학생 수 입력
        int n = sc.nextInt();

        //n명의 학생정보를 입력받아 리스트에 저장
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for(int i = 0; i < students.size(); i++){
            System.out.print(students.get(i).getName() + " ");
        }

    }

}
