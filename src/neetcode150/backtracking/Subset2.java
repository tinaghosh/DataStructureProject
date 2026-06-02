package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findAllSubsetsWithDup(0,nums,result,new ArrayList<>());
        return result;
    }
    public void findAllSubsetsWithDup(int index, int[] nums ,
                                      List<List<Integer>> result,
                                      List<Integer> inner ){

        result.add(new ArrayList<>(inner));

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            inner.add(nums[i]);
            findAllSubsetsWithDup(i+1,nums,result,inner);
            inner.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        Subset2 obj = new Subset2();
        List<List<Integer>> result = obj.subsetsWithDup(nums);
        result.forEach(e-> System.out.println(e));
    }
}
