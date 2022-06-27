import Lv2.FindTheDecimalNumberInTheKNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestMain {
    public static void main(String[] args){
        String s = "110011";
        String[] splitS = s.split("0");
        List<String> list = new ArrayList<String>(Arrays.asList(splitS));
        System.out.println(splitS.getClass().getName());
        list.removeAll(Collections.singletonList(""));
        System.out.println(list);
    }
}
