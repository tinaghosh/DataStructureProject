package neetcode150.array.slidingwindow;

import java.util.Arrays;

public class PermutationStrings {

    public boolean checkInclusion(String s1, String s2) {

        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        int n = s1.length();
        int left = 0;
        boolean same = false;

        for(int i = 0;i< s1.length();i++) {
            char c = s1.charAt(i);
            s1Array[c-'a']++;
        }

        Arrays.stream(s1Array).forEach(e-> System.out.print(e+","));

        for(int right = 0;right < s2.length();right++) {
            char c = s2.charAt(right);
            s2Array[c-'a']++;
            int windowLength = right-left+1;

            if(windowLength > n){
                char cleft = s2.charAt(left);
                s2Array[cleft-'a']--;
                windowLength--;
                left++;
            }
            System.out.println();
            Arrays.stream(s2Array).forEach(e-> System.out.print(e+","));
            same  = Arrays.equals(s1Array , s2Array);
            if(same){
                return true;
            }
        }
        return same;
    }

    public static void main(String[] args) {
       String s1 = "abc";
       String s2 = "lecabee";

        PermutationStrings obj = new PermutationStrings();
        boolean result = obj.checkInclusion(s1,s2);
        if(result) {
            System.out.println("\n S1 Present in S2");
        }else{
            System.out.println("\n S1 not Present in S2");
        }
    }
}
