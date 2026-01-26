package blind75.string.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minimumWindowSubstring(String s, String t){

        if(t.isEmpty()||s.isEmpty()||s.length()<t.length()){
            return "";
        }
        Map<Character,Integer> needMap = new HashMap<>();
        Map<Character,Integer> currentHaveMap = new HashMap<>();
        int condition = 0;
        int minLength = Integer.MIN_VALUE;
        int leftPointer = 0;
        int[] indexPair = {0,0};

        for(int i=0;i<t.length();i++){
            if(needMap.containsKey(t.charAt(i))){
                needMap.put(t.charAt(i),needMap.get(t.charAt(i))+1);
            }else{
                needMap.put(t.charAt(i),1);
            }
        }
        needMap.entrySet().forEach(e-> System.out.println(e.getKey()+"--->"+e.getValue()));

        for(int rightPointer=0;rightPointer<s.length();rightPointer++){
            char c = s.charAt(rightPointer);
            currentHaveMap.put(c,currentHaveMap.getOrDefault(c,0)+1);

            if(needMap.containsKey(c)){
                if(currentHaveMap.get(c).intValue() == needMap.get(c).intValue()){
                    condition++;
                }
            }

            while(condition == needMap.size()){

                if(minLength == Integer.MIN_VALUE || minLength >= (rightPointer-leftPointer)+1){
                    minLength = rightPointer - leftPointer+1;
                    indexPair[0]=leftPointer;
                    indexPair[1]=rightPointer;
                }

                char leftChar = s.charAt(leftPointer);
                currentHaveMap.put(leftChar,currentHaveMap.get(leftChar)-1);
                if(needMap.containsKey(leftChar) && (currentHaveMap.get(leftChar) < needMap.get(leftChar))){
                   condition--;
                }
                leftPointer++;
            }
        }
        if(minLength>0) {
            return s.substring(indexPair[0], indexPair[1]+1);
        }else{
            return "";
        }
    }

    public static void main(String[] args){
        String s = "a";//"ADOBECODEBANC";
        String t = "a";//"ABC";

        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String result = obj.minimumWindowSubstring(s,t);
        System.out.println("Minimum Length subString is "+result+" where all t's characters are present ");
    }
}
