package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        findAllPalindrome(result,new ArrayList<>(),0,s);
        return result;

    }
    public void findAllPalindrome( List<List<String>> result,  List<String> inner,
                                   int index, String s){

        if(index == s.length()){
            result.add(new ArrayList<>(inner));
            return;
        }

        for(int i=index;i<s.length();i++){
            String current = s.substring(index,i+1);
            if(isValidPalindrome(current)){
                inner.add(current);
                findAllPalindrome(result,inner,i+1,s);
                inner.removeLast();
            }
        }
    }

    public boolean isValidPalindrome(String s){

        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning obj = new PalindromePartitioning();
        List<List<String>> result = obj.partition(s);
        result.forEach(e-> System.out.println(e));
    }
}
