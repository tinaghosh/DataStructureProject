package blind75.binary;

public class NumberOf1Bits {

    public int countNumberOf1Bits(int n){
     int count = 0;

     for(int i=0;i<32;i++){
         int bit = n & 1;
         if(bit==1){
             count++;
         }
         n = n>>1;
     }
     return count;
    }

    public static void main(String[] args){
        int n =11;
        NumberOf1Bits obj = new NumberOf1Bits();
        int result = obj.countNumberOf1Bits(n);
        System.out.println("No of 1 bit present in given input -> "+result);
    }

}
