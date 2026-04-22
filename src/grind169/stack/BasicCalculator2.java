package grind169.stack;

import java.util.Stack;

public class BasicCalculator2 {

    public int calculate(String expression) {

        int number = 0;
        int result = 0;
        char sign = '+';
        int index = 0;

        Stack<Integer> stack = new Stack<>();

        expression = expression.trim();

        for (char c : expression.toCharArray()) {
            if (isDigit(c)) {
                number = 10 * number + (c - '0');
            }
            if(!isDigit(c) && c!=' ' || index == expression.length()-1){
                if (sign == '+') {
                    stack.push( number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = c;
                number =0;
            }
            index++;
        }

        result = 0;
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        return result;
    }

    public boolean isDigit(char c) {
        if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        BasicCalculator2 obj = new BasicCalculator2();
        String expression = "3+2*2";
        int result = obj.calculate(expression);
        System.out.println(result);
    }
}
