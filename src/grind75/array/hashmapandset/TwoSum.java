package grind75.array.hashmapandset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] findTwoSumCombination(int[] nums, int target){

        int[] output = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            if (map.containsKey(target-nums[i])){
                output[0]= map.get(target-nums[i]);
                output[1]= i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return output;
    }

    public static void main(String[] args){

        int[] nums = {2,7,11,15};
        int target =9;

        TwoSum obj = new TwoSum();
        int[] result = obj.findTwoSumCombination(nums,target);
        Arrays.stream(result).forEach(e-> System.out.print(e+","));
    }
}
