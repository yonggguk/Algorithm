package Lv2;

import java.util.*;
import java.lang.String;










//runtime Error
/*
public class ParkingFeeCalculation{

    public static int caculateTime(String inTime, String outTime){

        Integer inTimeHour = Integer.parseInt(inTime.split(":")[0]);
        Integer inTimeMinute = Integer.parseInt(inTime.split(":")[1]);
        Integer outTimeHour = Integer.parseInt(outTime.split(":")[0]);
        Integer outTimeMinute = Integer.parseInt(outTime.split(":")[1]);
        Integer parkingHour = outTimeHour - inTimeHour;
        Integer parkingMinute = 0;
        Integer parkingTime = 0;

        if(outTimeMinute < inTimeMinute){
            parkingHour -= 1;
            parkingMinute = 60 + outTimeMinute - inTimeMinute;
        }
        else{
            parkingMinute = outTimeMinute - inTimeMinute;
        }

        parkingTime = parkingHour * 60 + parkingMinute;

        return parkingTime;
    }
    public static int[] caculateFee(HashMap parkingTimeInfo, int[] feesInfo){

        HashMap<String, Integer> answer = new HashMap<>();
        int [] res = new int[parkingTimeInfo.size()];
        List<String> keyList = new ArrayList<>(parkingTimeInfo.keySet());
        keyList.sort((s1, s2)-> s1.compareTo(s2));

        for(Object infoKey : parkingTimeInfo.keySet()){
            if((Integer) parkingTimeInfo.get(infoKey) <= feesInfo[0]){
                answer.put((String)infoKey, feesInfo[1]);
            }
            else{
                Double addParingTime = Math.ceil(((Integer)parkingTimeInfo.get(infoKey) - feesInfo[0]*1.0) / feesInfo[2]);
                answer.put((String)infoKey, (int) (feesInfo[1] + addParingTime * feesInfo[3]));
                System.out.println(addParingTime);
            }
        }

        for(int i = 0; i < parkingTimeInfo.size(); i++){
            res[i] = answer.get(keyList.get(i));
        }
        return res;
    }

    public static void main(String args[]) {

        int[] fees = {180, 5000, 10, 600};

        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        HashMap<String, String> inMap = new HashMap<>();
        HashMap<String, String> outMap = new HashMap<>();
        HashMap<String, Integer> carParkingTime = new HashMap<>();

        for(String rec : records){
            String[] parkingInfo = rec.split(" ");
            carParkingTime.put(parkingInfo[1], 0);
        }

        for(String rec : records) {
            String[] parkingInfo = rec.split(" ");

            if (parkingInfo[2].equals("IN")) {
                inMap.put(parkingInfo[1], parkingInfo[0]);
            } else if (parkingInfo[2].equals("OUT")) {
                if (inMap.containsKey(parkingInfo[1])) {
                    carParkingTime.put(parkingInfo[1], carParkingTime.get(parkingInfo[1]) + caculateTime(inMap.get(parkingInfo[1]), parkingInfo[0]));
                    inMap.remove(parkingInfo[1]);
                    System.out.println(inMap);
                }
            }
        }
        if(!inMap.isEmpty()){
            for(String carNumber : inMap.keySet()){
                carParkingTime.put(carNumber, carParkingTime.get(carNumber) + caculateTime(inMap.get(carNumber), "23:59"));
                inMap.remove(carNumber);
            }

        }
        System.out.println(carParkingTime);
        System.out.println(Arrays.toString(caculateFee(carParkingTime, fees)));
    }
}*/

/*
public class ParkingFeeCalculation{

    public static HashMap<String, Integer> calculateParkingFee(HashMap<String, Integer> p, int[] f){
        HashMap<String, Integer> parkingInfo = p;
        int[] feesInfo = f;
        HashMap<String, Integer> res = new HashMap<>();

        for(String carKey : parkingInfo.keySet()){
            if(parkingInfo.get(carKey) <= feesInfo[0]){
                res.put(carKey, feesInfo[1]);
            } else{
                res.put(carKey, (int) (feesInfo[1] + (Math.ceil((parkingInfo.get(carKey) - feesInfo[0]) * 1.0  / feesInfo[2]) * feesInfo[3])));
            }
        }
        return res;
    }

    public int getMin(String time){
        String[] splitTime = time.split(":");
        int Hour = Integer.parseInt(splitTime[0]);
        int Min = Integer.parseInt(splitTime[1]);

        return Hour * 60 + Min;
    }

    public static void main(String args[]) {

        int[] fees = {1, 461, 1, 10};
        int parkingLastTime = 1439;
        String[] records = {"00:00 1234 IN"};

        HashMap<String, Integer> parkingCar = new HashMap<>();
        HashMap<String, Integer> parkingTime = new HashMap<>();
        List<String> cars = new ArrayList<>();

        for(String rec : records){
            String[] recSplit = rec.split(" ");
            String[] splitTime = recSplit[0].split(":");
            int Hour = Integer.parseInt(splitTime[0]);
            int Min = Integer.parseInt(splitTime[1]);
            int Time = Hour * 60 + Min;

            if(!cars.contains(recSplit[1])){
                cars.add(recSplit[1]);
            }

            if(!parkingCar.containsKey(recSplit[1])){
                parkingCar.put(recSplit[1], Time);
            }
            else if(parkingCar.containsKey(recSplit[1])){
                int calTime = Time - parkingCar.get(recSplit[1]);
                if(parkingTime.containsKey(recSplit[1])){
                    parkingTime.put(recSplit[1], parkingTime.get(recSplit[1]) + calTime);
                    parkingCar.remove(recSplit[1]);
                }
                else if(!parkingTime.containsKey(recSplit[1])){
                    parkingTime.put(recSplit[1], calTime);
                    parkingCar.remove(recSplit[1]);
                }
            }
        }
        for(String carKey : cars){
            if(parkingCar.containsKey(carKey)){
                int calTime = parkingLastTime - parkingCar.get(carKey);
                if(!parkingTime.isEmpty()) {
                    parkingTime.put(carKey, parkingTime.get(carKey) + calTime);
                }else{
                    parkingTime.put(carKey, calTime);
                }
            }
        }
        System.out.println(parkingTime);
        Collections.sort(cars);

        int[] parkingFeeRes = new int[cars.size()];
        HashMap<String, Integer> calRes = new HashMap<>();
        for(int i = 0; i < cars.size(); i++){
            for(String carKey : parkingTime.keySet()){
                if(parkingTime.get(carKey) <= fees[0]){
                    calRes.put(carKey, fees[1]);
                } else{
                    calRes.put(carKey, (int) (fees[1] + (Math.ceil((parkingTime.get(carKey) - fees[0]) * 1.0  / fees[2]) * fees[3])));
                }
            }
            parkingFeeRes[i] = calRes.get(cars.get(i));
        }
        System.out.println(Arrays.toString(parkingFeeRes));

    }

}*/

