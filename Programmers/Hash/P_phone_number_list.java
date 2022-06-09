import java.util.HashMap;
import java.util.Map;

public class P_phone_number_list {
    public static boolean Solution(String[] phone_book){
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], i);
        }
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j)))
                    return false;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[] s = {"119", "97674223", "1195524421"};
        boolean test = Solution(s);
        System.out.println(test);
    }
}
