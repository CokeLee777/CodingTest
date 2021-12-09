package programmers.searchword;

import java.util.Arrays;

public class MySourceCode {

    public static int[] solution(String[] words, String[] queries){
        int[] answer = new int[queries.length];

        Arrays.sort(words);

        //하나씩 비교해서 갯수 찾기
        for(int i = 0; i < queries.length; i++){
            String now = queries[i];
            int qLength = now.length();
            boolean start = false;
            //? 제거
            if(now.startsWith("?")) start = true;
            now = now.replaceAll("\\?", "");

            int result = findWords(words, now, start);

            answer[i] = result;
        }


        return answer;
    }

    private static int findWords(String[] words, String now, boolean checkStart) {
        int start = 0;
        int end = words.length - 1;

        int upperBound = findUpperBound(words, now, checkStart, start, end);
        int lowerBound = findLowerBound(words, now, checkStart, start, end);

        return upperBound - lowerBound;
    }

    private static int findUpperBound(String[] words, String now, boolean checkStart, int start, int end) {

        while(start < end){
            int mid = (start + end) / 2;
            //첫 단어가 ? 라면
            if(checkStart){
                //찾는 단어가 사전순으로 앞서있다면
                if(words[mid].substring(words[mid].length()-now.length()).compareTo(now) > 0) end = mid;
                else start = mid + 1;
            } else {
                //현재 단어가 사전순으로 앞선다면
                if(words[mid].substring(0,now.length()).compareTo(now) > 0) end = mid;
                else start = mid + 1;
            }
        }

        return end;
    }

    private static int findLowerBound(String[] words, String now, boolean checkStart, int start, int end) {
        while(start < end){
            int mid = (start + end) / 2;
            if(checkStart){
                //찾는 단어가 사전순으로 앞서있다면
                if(words[mid].substring(words[mid].length()-now.length()).compareTo(now) >= 0) end = mid;
                else start = mid + 1;
            } else {
                //찾는 단어가 사전순으로 앞서있다면
                if(words[mid].substring(0,now.length()).compareTo(now) >= 0) end = mid;
                else start = mid + 1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = solution(words, queries);

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}
