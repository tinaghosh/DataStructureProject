package neetcode150.array.slidingwindow;

import java.util.Arrays;

public class MoveZeros {

    public int[] moveZeros(int[] nums){
       int left =0;
       for(int right =0;right<nums.length;right++){
           if(nums[right]!=0){
               int temp = nums[right];
               nums[right]= nums[left];
               nums[left] = temp;
               left++;
           }
       }
       return nums;
    }

    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        MoveZeros obj = new MoveZeros();
        int[] result = obj.moveZeros(nums);

        Arrays.stream(result).forEach(e-> System.out.print(e+","));
    }
}
