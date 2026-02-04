package neetcode150.binary;

public class ReverseInteger {
    public int reverse(int x) {

        int sign = 1;
        long sum = 0;

        if(x<0) {
            sign = -1;
            x = x * sign;
        }
        while(x!=0){
            int reminder = x % 10 ;
            sum = sum * 10 + reminder;
            x = x / 10 ;
        }
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
            return 0;
        }
        return (int)sum * sign;
    }

    public static void main(String args[]){
        int i =-321;
        ReverseInteger obj = new ReverseInteger();
        int result = obj.reverse(i);
        System.out.println("Reverse of the given number is -> "+result);
    }
}
