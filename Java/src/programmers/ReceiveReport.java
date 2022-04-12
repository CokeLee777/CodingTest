package programmers;

import java.util.*;

public class ReceiveReport {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];

        //인덱스 번호에 따라 신고한 사람들 담기위한 리스트
        List<Set<String>> reportList = new ArrayList<>();
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            reportList.add(new HashSet<>());
            //각각의 이름에 따른 인덱스 번호 맵에 담기
            indexMap.put(id_list[i], i);
        }

        //신고 받기
        Map<String, Integer> reportedMap = new HashMap<>();
        for (String r : report) {
            String reportId = r.split(" ")[0];
            String reportedId = r.split(" ")[1];
            if(!reportList.get(indexMap.get(reportId)).contains(reportedId)){
                //각각의 인덱스에 따른 신고자들 입력받기
                reportList.get(indexMap.get(reportId)).add(reportedId);
                //각각의 이름에 따른 신고당한 횟수 입력받기
                reportedMap.put(reportedId, reportedMap.getOrDefault(reportedId, 0) + 1);
            }
        }

        //신고 리포트를 받은 사람 찾기
        for (String reportedId : reportedMap.keySet()) {
            //신고를 k번 이상 당했다면
            if(reportedMap.get(reportedId) >= k){
                for (int i = 0; i < reportList.size(); i++) {
                    if(reportList.get(i).contains(reportedId)){
                        ans[i]++;
                    }
                }
            }
        }

        return ans;
    }
}
