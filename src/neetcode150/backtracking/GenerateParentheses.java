package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAllOarenthesisCombination(result,"",n,0,0);
        return result;
    }

    public void generateAllOarenthesisCombination(List<String> result, String current ,
                                                  int n, int openCount ,int closeCount){

        if(current.length()== 2*n){
            result.add(current);
            return;
        }

        if(openCount<n){
            current = current + "(";
            generateAllOarenthesisCombination(result,current,n,openCount+1,closeCount);
            current = current.substring(0,current.length()-1);
        }

        if(closeCount<openCount){
            current = current + ")";
            generateAllOarenthesisCombination(result,current,n,openCount,closeCount+1);
            current = current.substring(0,current.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        GenerateParentheses obj = new GenerateParentheses();
        List<String> result = obj.generateParenthesis(n);
        result.forEach(e->System.out.println(e));
    }
}
