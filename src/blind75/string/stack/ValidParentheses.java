package blind75.string.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean checkValidParenthesis(String s){
        if(s.length()%2!=0){
            return false;
        }
        if(s.charAt(0)=='}'|| s.charAt(0)==']'|| s.charAt(0)==')'){
            return false;
        }

        Stack<Character> stack = new Stack();

        for(Character c : s.toCharArray()){

            if(c=='{'||c=='['|| c=='('){
                stack.push(c);
            }else if(!stack.isEmpty() && c==')' && stack.peek() == '('){
                stack.pop();
            }else if(!stack.isEmpty() && c=='}' && stack.peek() == '{'){
                stack.pop();
            } else if(!stack.isEmpty() && c==']' && stack.peek() == '['){
                stack.pop();
            } else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args){

        String s = "([}}])";

        ValidParentheses obj = new ValidParentheses();
        boolean result = obj.checkValidParenthesis(s);
        if(result){
            System.out.print("String is a valid Parenthesis");
        }else{
            System.out.print("String is not a valid Parenthesis");
        }
    }
}
