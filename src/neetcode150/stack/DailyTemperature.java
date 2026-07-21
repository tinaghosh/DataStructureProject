package neetcode150.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                output[i] =  stack.peek() - i;
            }else{
                output[i] = 0;
            }
            stack.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        DailyTemperature obj = new DailyTemperature();
        int[] result = obj.dailyTemperatures(temperatures);
        Arrays.stream(result).forEach(e->System.out.print(e+" "));
    }
}
