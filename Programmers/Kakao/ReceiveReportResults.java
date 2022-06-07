/*
2022 KAKAO BLIND RECRUITMENT
신고 결과 받기
*/

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, List<Integer> list = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            index.put(id_list[i], i);
        }
        
        for(String rep : report){
            String[] ids = rep.split(" ");
            String fromId = ids[0], toId=ids[1];
            if(!list.containKey(toId)) list.put(toId, new ArrayList<>());
            List<Integer> tmp = list.get(toId);
        }
    }
}
