package Chapter11.problem30;

import java.util.*;

public class MySourceCode2 {

    public static Set<String> wordSet = new HashSet<>();

    public static int[] solution(String[] words, String[] queries){
        int[] answer = new int[queries.length];

        Arrays.sort(words);

        //가사에 동일한 단어가 여러번 나올 경우 중복 제거
        wordSet.addAll(Arrays.asList(words));

        for (int i = 0; i < queries.length; i++) {
            boolean firstQ = queries[i].startsWith("?");
            int length = queries[i].length();
            String now = queries[i].replaceAll("\\?", "");

            for (String word : wordSet) {
                //길이부터 맞지 않으면 무시
                if(word.length() != length) continue;

                if(firstQ && word.endsWith(now)){
                    answer[i] += 1;
                    continue;
                }

                if(!firstQ && word.startsWith(now)){
                    answer[i] += 1;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = {"frodo","front","frost","frozen","frame","kakao"};
        String[] queries = {"fro??","????o","fr???","fro???","pro?"};

        int[] answer = solution(words, queries);

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
