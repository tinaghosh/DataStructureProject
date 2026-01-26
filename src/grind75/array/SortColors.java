package grind75.array;

import java.util.Arrays;

public class SortColors {

    public int[] sortColors(int[] nums ){

        int current = 0;
        int left = 0;
        int right = nums.length-1;

        while(current<=right){
            if(nums[current]==0){

                int temp =  nums[current];
                nums[current] = nums[left];
                nums[left] = temp;

                left++;
                current++;

            }else if(nums[current]==2){

                int temp =  nums[current];
                nums[current] = nums[right];
                nums[right] = temp;

                right--;

            }else{
                current++;
            }
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0}; //{2,0,1}

        SortColors obj = new SortColors();
        int[] result = obj.sortColors(nums);
        Arrays.stream(result).forEach(e-> System.out.print(e+","));

    }
}
