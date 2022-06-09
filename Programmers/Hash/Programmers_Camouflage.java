import java.util.*;

class Programmers_Camouflage {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1]));
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        answer = 1;
        for(String key : map.keySet()){
            answer *= map.get(key);
        }
        return answer-1;
    }
}
