package blind75.string.twopointer;

public class ValidPalindrome {

    public boolean checkPalindrome(String s){

        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
        System.out.println("String after Conversion : "+s);

        int start =0;
        int end =s.length()-1;

        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
               start++;
               end--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

       String s = "A man, a plan, a canal: Panama";

        ValidPalindrome obj = new ValidPalindrome();
        boolean result = obj.checkPalindrome(s);

        if(result){
            System.out.println("Given String is a valid Palindrome");
        }else{
            System.out.println("Given String is not a valid Palindrome");
        }

    }
}
