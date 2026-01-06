package grind75.string.hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int lengthOfTheLongestPalindrome(String s ){

        int length =0;
        char[] sArray = s.toCharArray();
        Map<Character,Integer> occurance = new HashMap<>();

        for(int i=0;i<sArray.length;i++){
            if(occurance.containsKey(sArray[i])){
                int count = occurance.get(sArray[i])+1;
                if(count%2==0){
                    length=length+2;
                }
                occurance.put(sArray[i],count);
            }else{
                occurance.put(sArray[i],1);
            }
        }
        long oddOccurance = occurance.entrySet().stream().filter(e->e.getValue()%2!=0).count();
        System.out.println(oddOccurance);

        if(oddOccurance>0){
            length++;
        }
        return length;
    }
    public static void main(String[] args){

        String s = "abccccdd";

        LongestPalindrome obj = new LongestPalindrome();
        int result = obj.lengthOfTheLongestPalindrome(s);
        System.out.println("The length of the longest palindrome that can be " +
                "built with those letters: "+result);

    }
}
