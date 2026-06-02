package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findAllCombinations(0, candidates, target,result, new ArrayList<>() );
        return result;

    }

    public void findAllCombinations(int index, int[] candidates, int target ,
                                    List<List<Integer>> result, List<Integer> inner){

        if(target == 0){
            result.add(new ArrayList<>(inner));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(target < candidates[i]){
                break;
            }
            if(i>index && candidates[i] == candidates[i-1]){
                continue;
            }

            inner.add(candidates[i]);
            findAllCombinations(i+1,candidates, target-candidates[i],result, inner);
            inner.remove(inner.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {9,2,2,4,6,1,5};
        int target = 8;

        CombinationSum2 obj = new CombinationSum2();
        List<List<Integer>> result = obj.combinationSum2(candidates,target);
        result.forEach(e-> System.out.println(e));
    }
}
