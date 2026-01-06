package grind75.array.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSumCombination(int[] nums){

        List<List<Integer>> combination = new ArrayList<>();

        System.out.println("Input Array before sorting ");
        Arrays.stream(nums).forEach(e->System.out.print(e+","));

        Arrays.sort(nums);
        System.out.println("\nInput Array after sorting ");
        Arrays.stream(nums).forEach(e->System.out.print(e+","));

        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;

            if(i>0 && nums[i] == nums[i-1]){
                //continue;
            }else {
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else {
                        List<Integer> inner = new ArrayList<>();
                        inner.add(nums[i]);
                        inner.add(nums[left]);
                        inner.add(nums[right]);
                        combination.add(inner);

                        while(left<right && nums[left]== nums[left+1]){
                            left++;
                        }

                        while(left<right && nums[right]== nums[right-1]){
                            right--;
                        }

                        left++;
                        right--;
                    }
                }
            }
        }

        return combination;
    }
    public static void main(String[] args){

        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum obj = new ThreeSum();
        List<List<Integer>> result = obj.threeSumCombination(nums);
        System.out.println("\nThree Integer Sum combination equals to Zero : ");
        result.forEach(e-> System.out.print("["+e.getFirst()+","+e.get(1)+","+e.getLast()+"]"));

    }
}
