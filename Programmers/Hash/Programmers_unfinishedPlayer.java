import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/*
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        for(i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
            if(i == (completion.length)-1){
                answer = participant[completion.length];
            }
        }
        return answer;
    }
}
*/
class Solution{
    public String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant){
            map.put(player,  map.getOrDefault(player, 0) + 1);
        }
        for(String player : completion){
            map.put(player, map.get(player) - 1);
        }
        
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
