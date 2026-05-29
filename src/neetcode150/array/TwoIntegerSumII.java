package neetcode150.array;

import java.util.Arrays;

public class TwoIntegerSumII {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;
        int[] result = new int[2];

        while(left<right){
            if(numbers[left]+ numbers[right] == target){
                result[0] = left+1;
                result[1] = right+1;

                return result;

            }else if(numbers[left]+ numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int target = 3;
        TwoIntegerSumII obj = new TwoIntegerSumII();
        int[] result = obj.twoSum(numbers,target);

        Arrays.stream(result).forEach(e->System.out.print(e+","));
    }
}
