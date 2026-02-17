package grind75.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    Map<Character,String> digitToLetter = new HashMap<>();
    List<String> output = null;

    public List<String> letterCombinationsOfAPhoneNumber(String s){

        output = new ArrayList<>();

        if(s.isEmpty()){
            return output;
        }

        digitToLetter.put('1',"");
        digitToLetter.put('2',"abc");
        digitToLetter.put('3',"def");
        digitToLetter.put('4',"ghi");
        digitToLetter.put('5',"jkl");
        digitToLetter.put('6',"mno");
        digitToLetter.put('7',"pqrs");
        digitToLetter.put('8',"tuv");
        digitToLetter.put('9',"wxyz");

        backTracking(output,s,0,"");
        return output;
    }

    public void backTracking(List<String> output,String input, int inputPointer,String currentString ){

        if(inputPointer>=input.length()){
            output.add(currentString);
            return;
        }

        char inputChar = input.charAt(inputPointer);
        String inputString = digitToLetter.get(inputChar);

        for(char c : inputString.toCharArray()){
            String temp = currentString;
            currentString = currentString + c;
            backTracking(output,input,inputPointer+1,currentString);
            currentString = temp;
        }
    }

    public static void main(String[] args){

        String digits = "23";

        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        List<String> result = obj.letterCombinationsOfAPhoneNumber(digits);
        result.forEach(e-> System.out.println(e+" "));
    }
}
