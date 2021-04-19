package Chapter11.problem23;

import java.util.*;

class Student implements Comparable<Student>{

    private String name;
    private int koreanScore;
    private int englishScore;
    private int mathScore;

    public Student(String name, int koreanScore, int englishScore, int mathScore) {
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public String getName() {
        return name;
    }

    public int getKoreanScore() {
        return koreanScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    @Override
    public int compareTo(Student student) {
        //국어점수가 높은 순서로 정렬
        if(this.koreanScore > student.koreanScore) return -1;
        //국어점수가 같으면
        else if (this.koreanScore == student.koreanScore) {
            //영어점수가 낮은 순서로 정렬
            if(this.englishScore < student.englishScore) return -1;
            //영어점수도 같다면
            else if (this.englishScore == student.englishScore) {
                //수학점수가 높은 순서로 정렬
                if(this.mathScore > student.mathScore) return -1;
                //수학점수도 같다면
                else if (this.mathScore == student.mathScore) {
                    // 이름순으로 정렬
                    return this.name.compareTo(student.name);
                } else return 1;
            } else return 1;
        } else return 1;
    }
}

public class MySourceCode {

    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //학생 수

        for(int i = 0; i < n; i++){
            String name = sc.next();
            int koreanScore = sc.nextInt();
            int englishScore = sc.nextInt();
            int mathScore = sc.nextInt();
            students.add(new Student(name, koreanScore, englishScore, mathScore));
        }

        Collections.sort(students);

        for(Student s: students){
            System.out.println("name = " + s.getName());
        }
    }
}
