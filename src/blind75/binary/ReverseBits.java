package blind75.binary;

public class ReverseBits {

    public int reverseBits(int n){

        int output = 0;

        for(int i=0;i<32;i++){
          output = output << 1; //[ shift result left ]
          int bit = n & 1;
          output = output | bit;
          n = n >> 1;  // [ shift n right ]
        }
        return output;
    }
    public static void main(String[] args){

        int input = 43261596; //binary representation -> 00000010100101000001111010011100;

        ReverseBits obj = new ReverseBits();
        int result = obj.reverseBits(input);
        System.out.println("Reverse Bit is :"+result);
    }
}
