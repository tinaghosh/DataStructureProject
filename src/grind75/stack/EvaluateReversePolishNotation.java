package grind75.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evaluateReversePolishNotation(String[] arr){

        Stack<Integer> stack = new Stack<>();

        for(String s: arr){
            if ((s.equals( "*")) || (s.equals("+")) || (s.equals("-")) || (s.equals("/"))){
               int a = stack.pop();
               int b = stack.pop();
               int calculation = 0;
               switch (s) {
                   case "+":
                       calculation =  a + b;
                       break;
                   case "-":
                       calculation =  b - a;
                       break;
                   case "*":
                       calculation =  a * b;
                       break;
                   case "/":
                       calculation = b / a;
                       break;
               }
               stack.push(calculation);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){

        String arr[] = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
        int result = obj.evaluateReversePolishNotation(arr);
        System.out.println("The result of the expression is :"+result);
    }
}
