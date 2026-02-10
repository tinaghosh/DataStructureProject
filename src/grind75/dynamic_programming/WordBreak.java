package grind75.dynamic_programming;

import java.util.List;

public class WordBreak {
    //************************  Using Recursion + Memo (Top-Down Approach) ************************//
    Boolean[] mem;
    public boolean checkWorkBreakPossibility(String s , List<String> wordDict){
        mem = new Boolean[s.length()];
        return recursion(s,wordDict,0);
    }

    public boolean recursion(String s , List<String> wordDict , int index){
       if(index == s.length()){
           return true;
       }
       if(wordDict.contains(s)){
           return mem[index] = true;
       }
       if(mem[index]!=null){
           return mem[index];
       }
       //While creating substring we can take any Length starting from 1 to till the length
       for(int len=1;index+len<=s.length();len++){
        String subString = s.substring(index,index+len);
        if(wordDict.contains(subString)){
            if(recursion(s,wordDict,index+len)){
                return mem[index] = true;
            }
          }
       }
       return mem[index] = false;
    }

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//

    public boolean checkWorkBreakPossibilityBottomUp(String s , List<String> wordDict){
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;

        for(int len=1;len<=s.length();len++){
            for(int i=0; i<len;i++){
              String subString = s.substring(i,len);
              if(result[i] && wordDict.contains(subString)){
                 result[len] = true;
              }
            }
        }
        return result[s.length()];
    }

    //*********************************  Using Bottom-Up Approach *********************************//
    public static void main(String[] args){
        String sTrueCase = "applepenapple";
        List<String> wordDictTrue = List.of("apple", "pen");
        String sFalseCase = "catsandog";
        List<String> wordDictFalse = List.of("cats","dog","sand","and","cat");

        WordBreak obj = new WordBreak();
        boolean resultTrueCase = obj.checkWorkBreakPossibility(sTrueCase,wordDictTrue);
        if(resultTrueCase){
            System.out.println(sTrueCase+"-> for this word break is possible");
        }else{
            System.out.println(sTrueCase+"-> for this word break is not possible");
        }

        boolean resultFalseCase = obj.checkWorkBreakPossibility(sFalseCase,wordDictFalse);
        if(resultFalseCase){
            System.out.println(sFalseCase+"-> for this word break is possible");
        }else{
            System.out.println(sFalseCase+"-> for this word break is not possible");
        }

        boolean resultTrueCaseBottomUp = obj.checkWorkBreakPossibilityBottomUp(sTrueCase,wordDictTrue);
        if(resultTrueCaseBottomUp){
            System.out.println(sTrueCase+"-> for this word break is possible");
        }else{
            System.out.println(sTrueCase+"-> for this word break is not possible");
        }

        boolean resultFalseCaseBottomUp = obj.checkWorkBreakPossibilityBottomUp(sFalseCase,wordDictFalse);
        if(resultFalseCaseBottomUp){
            System.out.println(sFalseCase+"-> for this word break is possible");
        }else{
            System.out.println(sFalseCase+"-> for this word break is not possible");
        }
    }
}
