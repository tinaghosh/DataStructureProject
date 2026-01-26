package blind75.string.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthofLongestSubstringWithoutRepeatingChars(String s){

        Set<Character> uniqueChar = new HashSet<>();
        int leftPointer = 0;
        int maxWindowLength = 0;

        for(int rightPointer=0;rightPointer<s.length();rightPointer++) {
            char c = s.charAt(rightPointer);
            while(uniqueChar.contains(c)){
                  uniqueChar.remove(s.charAt(leftPointer));
                  leftPointer++;
            }
            uniqueChar.add(c);
            maxWindowLength = Math.max(maxWindowLength,rightPointer-leftPointer+1);
        }
        return maxWindowLength;
    }
    public static void main(String[] args){
       String s = "pwwkew";//"abcabcbb";

       LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
       int result = obj.lengthofLongestSubstringWithoutRepeatingChars(s);
       System.out.println("The length of the longest substring without duplicate characters :"+result);
    }
}
