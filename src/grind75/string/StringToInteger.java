package grind75.string;

public class StringToInteger {

    public int convertedInteger(String s){

        int output=0;
        boolean isNegativeInteger = false;
        s= s.trim();
        boolean first = true;
        for(char c:s.toCharArray()){
            if((c=='-'||c=='+') && first ){
               if(c=='-'){
                   isNegativeInteger=true;
               }
               first=false;
               continue;
            }else{
               if(isDigit(c)){
                   if (output > Integer.MAX_VALUE / 10 || (output == Integer.MAX_VALUE / 10 && c-'0' > 7)) {
                       return  !isNegativeInteger ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                   }
                   output = output*10+(c-'0');
               }else{
                   break;
               }
            }
            first=false;
        }
        if(isNegativeInteger){
            output= -1 * output;
        }
       return output;
    }

    public boolean isDigit(char c){
        int i=c-'0';
        if(0<=i && i<=9){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        String s = "+-12";//""0-1";

        StringToInteger obj = new StringToInteger();
        int result = obj.convertedInteger(s);
        System.out.println("Converted Integer from String is :"+result);
    }
}
