package blind75.dynamic_programming;

public class DecodeWays {
    public int numberOfWaysToecode(String s){
        //int count = Integer.MIN_VALUE;

        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int onedigit = 1;
        int twodigit = 1;

        for(int i=1;i<s.length();i++){
            int count = 0;
            if(s.charAt(i)!='0'){
               count = onedigit;
            }

            int twoDigitInt = Integer.parseInt(s.substring(i-1,i+1));
            if(10<=twoDigitInt && twoDigitInt<=26){
                count = count + twodigit;
            }
            twodigit = onedigit;
            onedigit = count;
        }
        return onedigit;
    }
    public static void main(String[] args){
        String s ="2101";
        DecodeWays obj = new DecodeWays();
        int result = obj.numberOfWaysToecode(s);
        System.out.println("No of ways we can decode the string is -> "+result);
    }
}
