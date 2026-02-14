package grind75.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> findSubsets(int[] nums){

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        formSubset(0, nums, output, current);

        return output;
    }

    public List<List<Integer>> formSubset( int index, int nums[],List<List<Integer>> output,List<Integer> current){

        output.add(new ArrayList<>(current));

        for(int i=index;i<nums.length;i++) {
            current.add(nums[i]);
            formSubset(i+1, nums,output,current);
            current.remove(current.size()-1);
        }
        return output;
    }

    public static void main(String[] args){
       int[] nums = {1,2,3};

        Subsets obj = new Subsets();
        List<List<Integer>> result = obj.findSubsets(nums);
        result.forEach(e-> {
            System.out.print("[");
            e.forEach(einner-> System.out.print(einner+","));
            System.out.println("]");
        });
    }
}
