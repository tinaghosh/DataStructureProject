package grind75.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permutations(int[] input){
        List<List<Integer>> output = new ArrayList<>();
        boolean[] used = new boolean[input.length];
        permutationsBackTrack(input,used,output,new ArrayList<>());
        return output;
    }

    public List<List<Integer>> permutationsBackTrack(int[] input,boolean[] used,List<List<Integer>> output,List<Integer> current){

        if(input.length==current.size()){
            output.add(new ArrayList<>(current));
        }
        for(int i=0;i<input.length;i++){
            if(!used[i]){
                current.add(input[i]);
                used[i] = true;
                permutationsBackTrack(input,used,output,current);
                used[i] = false;
                current.remove(current.size()-1);
            }
        }
        return output;
    }
    public static void main(String[] args){
        int[] input = {1,2,3};
        Permutations obj = new Permutations();
        List<List<Integer>> result = obj.permutations(input);
        result.forEach(e->{
            System.out.print("[");
            e.forEach(i->System.out.print(i+","));
            System.out.println("]");
        });
    }
}
