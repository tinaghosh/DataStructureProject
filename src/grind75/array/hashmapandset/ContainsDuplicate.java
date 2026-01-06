package grind75.array.hashmapandset;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean arrayContainsDuplicateElement(int[] nums){
        Set<Integer> numberSets= new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(numberSets.contains(nums[i])){
                return true;
            }else{
                numberSets.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1};

        ContainsDuplicate obj = new ContainsDuplicate();
        boolean result = obj.arrayContainsDuplicateElement(nums);

        if(result) {
            System.out.println("Duplicate element present in Array");
        }else{
            System.out.println("Duplicate element not present in Array");
        }
    }
}
