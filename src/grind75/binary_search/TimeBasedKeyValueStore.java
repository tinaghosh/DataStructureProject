package grind75.binary_search;

import java.util.*;

public class TimeBasedKeyValueStore {

    Map<String,TreeMap<Integer,String>> timeMap = null;
    Map<String, List<Pair>> timeMapCustom  = null;

    public TimeBasedKeyValueStore() {
        timeMapCustom = new HashMap<>();
    }

    public TimeBasedKeyValueStore(boolean treemap) {
       timeMap = new HashMap<>();
    }

    public void set(String key,String value, int timestamp){

        if(!timeMapCustom.containsKey(key)){
           Pair pair = new Pair(timestamp,value);
           List<Pair> timeList = new ArrayList<>();
           timeList.add(pair);
           timeMapCustom.put(key,timeList);
        }else{
            List<Pair> timeList = timeMapCustom.get(key);
            timeList.add(new Pair(timestamp,value));
            timeMapCustom.put(key,timeList);
        }
    }
    public String get(String key, int timestamp){

        if(!timeMapCustom.containsKey(key)){
            return "";
        }else{
            List<Pair> timeList = timeMapCustom.get(key);
            String value = "";
            int left = 0; int right = timeList.size()-1;

            while(left<=right){
                int mid = left + (right - left)/2;
                if(timeList.get(mid).timeStamp <= timestamp){
                    value = timeList.get(mid).value;
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            return value;
        }
    }

    //Using TreeMap

    public void setUsingTreeMap(String key,String value, int timestamp){

        if(!timeMap.containsKey(key)) {
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            timeMap.put(key, treeMap);
        }else{
            TreeMap<Integer, String> treeMap = timeMap.get(key);
            treeMap.put(timestamp,value);
            timeMap.put(key, treeMap);
        }
    }

    public String getUsingTreeMap(String key,int timestamp){

        TreeMap<Integer, String> treeMap = timeMap.get(key);
        if(treeMap==null){
            return "";
        }else{
            Map.Entry<Integer,String> entry = treeMap.floorEntry(timestamp);
            return entry.getValue();
        }
    }

    public static void main(String[] args){

      String[] operations = {"TimeMap", "set", "get", "get", "set", "get", "get"};
      Object[][] input = {{}, {"foo", "bar", 1}, {"foo", 1}, {"foo", 3}, {"foo", "bar2", 4}, {"foo", 4}, {"foo", 5}};

      TimeBasedKeyValueStore obj1 = null;
      TimeBasedKeyValueStore obj2 = null;

      for(int i=0;i<operations.length;i++){
          if(operations[i].equals("TimeMap")){

              obj1 = new TimeBasedKeyValueStore();
              obj2 = new TimeBasedKeyValueStore(true);

          }else if(operations[i].equals("set")){

              Object[] inner = input[i];
              obj1.set(inner[0].toString(),inner[1].toString(),(int)inner[2]);
              obj2.setUsingTreeMap(inner[0].toString(),inner[1].toString(),(int)inner[2]);

          }else if(operations[i].equals("get")){

              Object[] inner = input[i];
              String result = obj1.get(inner[0].toString(),(int)inner[1]);
              System.out.print(result+" ");

              String resultTree = obj2.getUsingTreeMap(inner[0].toString(),(int)inner[1]);
              System.out.print(resultTree+" ");
          }
      }
    }

    private static class Pair{
        int timeStamp;
        String value;

        Pair(int timeStamp,String value){
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }
}
