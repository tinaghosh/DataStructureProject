package blind75.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> output;

    public List<List<Integer>> findAllCombinationsOfTarget(int[] candidates,int target){
        output = new ArrayList<>();
        backTracking(target,0,candidates, new ArrayList<>());
        return output;
    }

    public void backTracking(int target, int index, int[] candidates,List<Integer> current){

      if(target < 0){
          return;
      }

      if(index >= candidates.length){
            return;
      }

      if(target == 0){
          output.add(new ArrayList<>(current));
          return;
      }

      if(candidates[index] <= target){
              current.add(candidates[index]);
              backTracking(target - candidates[index], index, candidates, current);
              current.removeLast();
       }

      backTracking(target, index+1, candidates, current);
    }

    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;

        CombinationSum obj = new CombinationSum();
        List<List<Integer>> result = obj.findAllCombinationsOfTarget(candidates,target);
        result.forEach(e-> {
            System.out.print("[");
            e.forEach(einner->System.out.print(einner+","));
            System.out.println("]");
        });
    }
}
