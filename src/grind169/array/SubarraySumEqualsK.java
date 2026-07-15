package grind169.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum-k)){
                count = map.get(sum-k)+count ;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1,-1,0};
        int k = 0;
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int result = obj.subarraySum(nums,k);
        System.out.println(result);
    }
}
