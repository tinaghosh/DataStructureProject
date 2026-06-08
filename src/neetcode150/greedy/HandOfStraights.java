package neetcode150.greedy;

import java.util.TreeMap;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {

       if(hand.length % groupSize !=0){
           return false;
       }
       TreeMap<Integer,Integer> freqSortedMap = new TreeMap<>();

       for(int i=0;i<hand.length;i++){
           freqSortedMap.put(hand[i],freqSortedMap.getOrDefault((hand[i]),0)+1) ;
       }

       while(freqSortedMap.size()>0){

           int current = freqSortedMap.firstKey();

           for(int i=0;i<groupSize;i++) {
               if (!freqSortedMap.containsKey(current+i)){
                   return false;
               }
               freqSortedMap.put(current+i,freqSortedMap.get(current+i)-1);

               if(freqSortedMap.get(current+i)==0){
                   freqSortedMap.remove(current+i);
               }
           }
       }
        return true;
    }

    public static void main(String[] args) {

        int[] hand = {1,2,4,2,3,5,3,4};
        int groupSize = 4;

        HandOfStraights obj = new HandOfStraights();
        boolean result = obj.isNStraightHand(hand,groupSize);

        if(result){
            System.out.println("HandOfStraights Possible");
        }else{
            System.out.println("HandOfStraights not Possible");
        }

    }
}
