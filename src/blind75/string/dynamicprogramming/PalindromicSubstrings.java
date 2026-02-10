package blind75.string.dynamicprogramming;

import java.util.Arrays;

public class PalindromicSubstrings {

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//
    int[][] mem;

    public int noOfPalindromicSubstrings(String s) {

        int count = 0;
        mem = new int[s.length()][s.length()];
        Arrays.stream(mem).forEach(e -> {
            Arrays.fill(e, -1);
        });

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean check = checkPalindrome(s, i, j);
                if (check) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean checkPalindrome(String s, int left, int right) {

        if (mem[left][right] != -1) {
            return mem[left][right] == 1;
        }
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            boolean value = checkPalindrome(s, left + 1, right - 1);
            if (value) {
                mem[left][right] = 1;
            } else {
                mem[left][right] = 0;
            }
            return value;
        }
        mem[left][right] = 0;
        return false;
    }

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//


    //*********************************  Using Bottom-Up Approach *********************************//

    public int noOfPalindromicSubstringsBottomUp(String s) {

        int count = 0;
        boolean[][] result = new boolean[s.length()][s.length()];

        Arrays.stream(result).forEach(e->{
            Arrays.fill(e,false);
        });

        for(int len=1;len<=s.length();len++){  //calculating for all string where substring length = [1 to s.length]
            for(int i=0;i+len<=s.length();i++){ //Index will start from 0 for each substring and end i+currentLength
                 int j= i+len-1; // j is -1 as index is starting from inex 0
                 if(i==j){ //when length of substring is 1
                     result[i][j] = true;
                 }
                 else if(i+1==j){ //when length of substring is 2
                    result[i][j] = s.charAt(i) == s.charAt(j) ;
                 }else{
                    result[i][j] = s.charAt(i) == s.charAt(j) && result[i+1][j-1];
                 }
                if(result[i][j]){
                    count++;
                }
            }
        }
      return count;
    }

    //*********************************  Using Bottom-Up Approach *********************************//

    //*************************  Using Samrt Approach) ********************//

    int count = 0;

    public int noOfPalindromicSubstringsBottomUpSmart(String s) {
        for(int i=0;i<s.length();i++){
          checkPalindromeSmart(s,i,i); //for odd length Palindrome considering s.char[i] as center
          checkPalindromeSmart(s,i,i+1); //for even length Palindrome considering s.char[i] as center
        }
      return count;
    }

    public void checkPalindromeSmart(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)== s.charAt(j)){
            count++;
            i--;
            j++;
        }
    }

    //*************************  Using Samrt Approach ********************//

    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubstrings obj = new PalindromicSubstrings();

        int result = obj.noOfPalindromicSubstrings(s);
        System.out.println("The number of palindromic substrings in it -> " + result);

        int resultBottomUp = obj.noOfPalindromicSubstringsBottomUp(s);
        System.out.println("The number of palindromic substrings in it -> " + resultBottomUp);

        int resultresultBottomUpSmart = obj.noOfPalindromicSubstringsBottomUpSmart(s);
        System.out.println("The number of palindromic substrings in it -> " + resultresultBottomUpSmart);
    }
}
