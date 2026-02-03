package grind75.stack;

import java.util.Stack;

public class BasicCalculator {

    public int basicCalculatorOperation(String s){

        s = s.trim();
        int result = 0;
        int number = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack();

        for(char c: s.toCharArray()){
            if(isDigit(c)){
                number = number*10 + (c-'0');
            }else if(c=='-'){
                result = result + (sign * number);
                number = 0;
                sign = -1;
            }else if(c=='+'){
                result = result +(sign * number);
                number = 0;
                sign = 1;
            }else if(c =='('){
               stack.push(result);
               stack.push(sign);
               result = 0;
               sign = 1;
            }else if(c == ')'){
                result = result + (sign * number);
                number = 0;
                result = stack.pop() * result;
                result = result + stack.pop();
            }
        }
        result = result + (sign * number);
      return result ;
    }
    public boolean isDigit(char c){
       if(c-'0' >= 0 && c-'0'<= 9){
          return true;
       }
       return false;
    }
   public static void main(String[] args){
        String s = "10-(4+5+2)-3+(6+8)";
        String s1 = "1 + 1";

        BasicCalculator obj = new BasicCalculator();
        int result = obj.basicCalculatorOperation(s1);
        System.out.println("Mathematical Result of the expression is -> "+result);
    }
}
