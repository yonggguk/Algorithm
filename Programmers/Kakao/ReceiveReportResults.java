/*
2022 KAKAO BLIND RECRUITMENT
신고 결과 받기
*/
import java.util.*;

class ReceiveReportResults {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, List<Integer>> list = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            index.put(id_list[i], i);
        }
        
        for(String rep : report){
            String[] ids = rep.split(" ");
            String fromId = ids[0], toId=ids[1];
            if(!list.containsKey(toId)){
                list.put(toId, new ArrayList<>());
            }
            List<Integer> tmp = list.get(toId);
            if(!tmp.contains(index.get(fromId))){
                tmp.add(index.get(fromId));
            }
            System.out.println(System.identityHashCode(tmp));
            System.out.println(System.identityHashCode(list.get(toId)));
        }

        for(int i = 0; i < id_list.length; i++){
            String id = id_list[i];
            System.out.println(id);
            if(list.containsKey(id) && list.get(id).size() >= k){
                for(int idx : list.get(id)){
                    answer[idx]++;
                }
            }
        }
        return answer;
    }
}
