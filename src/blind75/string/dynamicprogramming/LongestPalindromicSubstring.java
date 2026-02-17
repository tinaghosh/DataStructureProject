package blind75.string.dynamicprogramming;

public class LongestPalindromicSubstring {

    public String longestPalindromicSubstring(String s){

        if(s.isEmpty()){
           return "";
        }

        if(s.length()==1){
            return s;
        }

        int left = 0, right=0;

        for(int i=0;i<s.length();i++){

            int evenLength =  validPalindromeLength(s, i, i + 1);
            int oddLength = validPalindromeLength(s,i,i);
            int len = Math.max(evenLength,oddLength);

            // A single letter is always Palindromic . So if we get bigger length then update
            // the left right based on date and return the logest Pallindrome.
            // Here from length we are calculating start and end index .
            //Consider i the middle point of the length then left is i-<length/2> right is i+<length/2>
            //for even length two mid point can be there hence left = i-<length-1>/2

            if(len>right-left){
               left = i-(len-1)/2;
               right = i+len/2;
            }
         }

      return s.substring(left,right+1);
    }
    public int validPalindromeLength(String s , int left , int right){

        int maxLength = 0;

        while(left>=0 && right<s.length()) {
            if (s.charAt(left) == s.charAt(right)){
                maxLength = Math.max(maxLength,right-left+1);
            }else{
                break;
            }
            left--;
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args){
        String sOddLength = "abbcccba";//"babad";
        String sEvenLenth = "cbbd";

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        String result1 = obj.longestPalindromicSubstring(sOddLength);
        System.out.println("Longest Palindromic SubString of "+sOddLength+" is : "+result1);
        String result2 = obj.longestPalindromicSubstring(sEvenLenth);
        System.out.println("Longest Palindromic SubString of "+sEvenLenth+" is : "+result2);
    }
}
