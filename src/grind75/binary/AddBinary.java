package grind75.binary;

public class AddBinary {

    public String addBinary(String a , String b){
        StringBuilder output = new StringBuilder();
        int carry = 0;

        int aPointer = a.length()-1;
        int bPointer = b.length()-1;

        while(aPointer>=0 || bPointer>=0 || carry>0 ){

            int adigit = 0 ;
            int bdigit = 0 ;

            if(aPointer>=0) {
              adigit = a.charAt(aPointer) - '0';
            }
            if(bPointer>=0) {
                bdigit = b.charAt(bPointer) - '0';
            }
            int sum = adigit+bdigit+carry;
            aPointer--;
            bPointer--;

            carry = sum/2;
            output.append(sum%2);
        }
        return output.reverse().toString();
    }

    public static void main(String[] args){
        String a = "1010";
        String b = "1011";

        AddBinary obj = new AddBinary();
        String result = obj.addBinary(a,b);
        System.out.println("After adding two binary number result is -> "+result);
    }
}
