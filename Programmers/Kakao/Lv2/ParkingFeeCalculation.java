package Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.lang.String;

public class ParkingFeeCalculation{

    public static void main(String args[]){
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        HashMap<String, String> inMap = new HashMap<String, String>();
        HashMap<String, String> outMap = new HashMap<String, String>();
        Object[] mapKeySort;
        for(String i : records){
            String[] splitRecords = i.split(" ");
            //System.out.println(splitRecords[2]);
            if(splitRecords[2].equals("IN")){
                inMap.put(splitRecords[1], splitRecords[0]);
            }
            else if(splitRecords[2].equals("OUT")){
                outMap.put(splitRecords[1], splitRecords[0]);
            }
        }
        mapKeySort = inMap.keySet().toArray();
        Arrays.sort(mapKeySort);
        for(Object inMapKey : mapKeySort){
            System.out.println(inMap.get(inMapKey));
            System.out.println(outMap.get(inMapKey));
        }

    }
}