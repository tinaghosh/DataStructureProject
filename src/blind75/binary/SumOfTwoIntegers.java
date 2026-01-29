package blind75.binary;

public class SumOfTwoIntegers {

    public int add(int a,int b){

        int carry = 0;
        int sum = 0;
        boolean first = true;

        while(carry>0 || first){
            carry = a & b;
            int sumWithoutCarry= a ^ b;
            carry = carry<<1;
            sum = sumWithoutCarry ^ carry;
            a = sumWithoutCarry;
            b = carry;
            first = false;
        }

        return sum;
    }

    public static void main(String[] args){
        int a = 2;
        int b = 3;

        SumOfTwoIntegers obj = new SumOfTwoIntegers();
        int result = obj.add(a,b);
        System.out.println("Sum of two integer : "+result);

    }
}
