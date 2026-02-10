package grind75.dynamic_programming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    int[][] mem;
    public int lengthOfLongestCommonSubsequence(String text1,String text2){

        mem = new int[text1.length()+1][text2.length()+1];
        Arrays.stream(mem).forEach(e->{
            Arrays.fill(e,-1);
        });

        return recursion(text1,text2,0,0);
    }

    public int recursion(String text1, String text2,int indexOfText1,int indexOfText2){

        int excludeFromtext1 = 0 ;
        int excludeFromtext2 = 0 ;

        if(mem[indexOfText1][indexOfText2]!=-1){
            return mem[indexOfText1][indexOfText2];
        }

        if(indexOfText1 == text1.length() || indexOfText2 == text2.length()){
            return 0;
        }

        if(text1.charAt(indexOfText1) == text2.charAt(indexOfText2)){
            mem[indexOfText1][indexOfText2] = 1 + recursion(text1,text2,indexOfText1+1,indexOfText2+1);
        }else {
            excludeFromtext1 = recursion(text1, text2,indexOfText1+1, indexOfText2);
            excludeFromtext2 = recursion(text1, text2, indexOfText1,indexOfText2+1);
            mem[indexOfText1][indexOfText2] =  Math.max(excludeFromtext1,excludeFromtext2);
        }
        return mem[indexOfText1][indexOfText2];
    }
    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//
    public int lengthOfLongestCommonSubsequenceBottomUp(String text1,String text2){

        int[][] result = new int[text1.length()+1][text2.length()+1];

        for(int i=0;i<=text1.length();i++){
           for(int j=0;j<=text2.length();j++){
               if(i==0 || j==0){
                   result[i][j] = 0;
               }
               else if(text1.charAt(i-1) == text2.charAt(j-1)){
                   result[i][j] = 1+ result[i-1][j-1];
               }else{
                   result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
               }
           }
        }
        return result[text1.length()][text2.length()];
    }

    //*********************************  Using Bottom-Up Approach *********************************//
    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        int result = obj.lengthOfLongestCommonSubsequence(text1,text2);
        System.out.println("Length of their longest common subsequence -> "+result);

        int resultBottomUp = obj.lengthOfLongestCommonSubsequenceBottomUp(text1,text2);
        System.out.println("Length of their longest common subsequence -> "+resultBottomUp);
    }
}
