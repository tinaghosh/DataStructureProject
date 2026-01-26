package grind75.string.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minimumWindowSubstring(String s, String t) {

        if(t.isEmpty()||s.isEmpty()||s.length()<t.length()){
            return "";
        }

        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> haveMap = new HashMap<>();
        int haveMatching = 0;
        int leftPointer = 0;
        int minWindowLength = Integer.MIN_VALUE;
        int[] indexPair ={0,0};

        for(char tChar : t.toCharArray()){
            needMap.put(tChar,needMap.getOrDefault(tChar,0)+1);
        }
        needMap.entrySet().forEach(e-> System.out.print(e.getKey()+"-->"+e.getValue()));

        for(int rightPointer = 0;rightPointer<s.length();rightPointer++){

            char sChar = s.charAt(rightPointer);
            haveMap.put(sChar,haveMap.getOrDefault(sChar,0)+1);

            if(needMap.containsKey(sChar)){
                if(needMap.get(sChar).intValue()==haveMap.get(sChar).intValue()){
                    haveMatching++;
                }
            }

            while(haveMatching==needMap.size()){
                if(minWindowLength == Integer.MIN_VALUE || minWindowLength>=(rightPointer-leftPointer+1)){
                    minWindowLength = rightPointer-leftPointer+1;
                    indexPair[0] = leftPointer;
                    indexPair[1] = rightPointer;
                }

                char leftChar = s.charAt(leftPointer);
                haveMap.put(leftChar,haveMap.get(leftChar)-1);
                if(needMap.containsKey(leftChar) && haveMap.get(leftChar) < needMap.get(leftChar)){
                    haveMatching--;
                }
                leftPointer++;
            }
        }
        if(minWindowLength>0){
            return s.substring(indexPair[0],indexPair[1]+1);
        }else{
            return "";
        }
    }

    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String result = obj.minimumWindowSubstring(s,t);
        System.out.println("\nMinimum Length subString is "+result+" where all t's characters are present ");
    }
}
