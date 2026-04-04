package general.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSumCombination(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){

                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int left = j+1;
                int right = nums.length-1;

                while(left<right){

                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];

                    if(sum==target){

                        List<Integer> inner = new ArrayList<>();

                        inner.add(nums[i]);
                        inner.add(nums[j]);
                        inner.add(nums[left]);
                        inner.add(nums[right]);

                        output.add(inner);

                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }

                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }

                        left++;
                        right--;

                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] args){

        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        FourSum obj = new FourSum();
        List<List<Integer>> result = obj.fourSumCombination(nums,target);
        System.out.println("\nFour Integer Sum combination equals to Zero : ");
        result.forEach(e-> System.out.print("["+e.getFirst()+","+e.get(1)+","+e.get(2)+","+e.getLast()+"]"));

    }
}
