package blind75.graph;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int maxLengthOfLongestConsecutiveSeq(int[] nums){

        if(nums.length==0){
            return 0;
        }

        int maxLength = 0;
        Set<Integer> numSet  = new HashSet<>();

        for(int i: nums){
            numSet.add(i);
        }

        for(int i : numSet){
          if(numSet.contains(i-1)){
              continue;
          }else{
              int currentNum = i;
              int currentLength = 1;
              while(numSet.contains(currentNum+1)){
                  currentNum = currentNum+1;
                  currentLength++;
              }
              maxLength = Math.max(currentLength,maxLength);
          }
        }
        return maxLength;
    }

    public static void main(String[] args){
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int result = obj.maxLengthOfLongestConsecutiveSeq(nums);
        System.out.println("Length of the longest consecutive elements sequence -> "+result);
    }
}
