package neetcode150.bitmanipulation;

public class ReverseInteger {
    public int reverse(int n) {
        int reverse =0;
        while(n!=0){
            if(reverse<Integer.MIN_VALUE/10 || reverse>Integer.MAX_VALUE/10){
                return 0;
            }
            reverse = 10*reverse+(n%10);
            n=n/10;
        }
        return reverse;
    }

    public static void main(String[] args){
        int i =-321;
        ReverseInteger obj = new ReverseInteger();
        int result = obj.reverse(i);
        System.out.println("Reverse of the given number is -> "+result);
    }
}
