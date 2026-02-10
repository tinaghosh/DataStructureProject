package grind75.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    int[][] mem;

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//
    public int lengthOfLongestIncreasingSubsequence(int[] nums) {

        mem = new int[nums.length+1][nums.length+1];
        Arrays.stream(mem).forEach(e -> {
            Arrays.fill(e, -1);
        });

        return recursion(nums, 0, -1);
    }

    public int recursion(int[] arr, int currentIndex, int prevIndex) {

        if (currentIndex >= arr.length) {
            return 0;
        }
        if (prevIndex != -1 && mem[currentIndex][prevIndex] != -1) {
            return mem[currentIndex][prevIndex];
        }

        int taken = 0;
        if (prevIndex == -1 || arr[prevIndex] < arr[currentIndex]) {
            taken = 1 + recursion(arr, currentIndex + 1, currentIndex);
        }

        int notTaken = recursion(arr, currentIndex + 1, prevIndex);

        if (prevIndex != -1) {
            mem[currentIndex][prevIndex] = Math.max(taken, notTaken);
        }
     return Math.max(taken, notTaken);
    }
    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//

    public  int lengthOfLongestIncreasingSubsequenceBottomUp(int[] arr){

        int[] result = new int[arr.length+1];

        Arrays.fill(result,1); //all the lement is a individual subsequence hence by default
                                    //in the result array till ith Position minimum subsequence length
                                    //will be 1.

        int maxLIS = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++) {
                if(arr[i]>arr[j]){
                    result[i] = Math.max(result[i],result[j]+1);
                    maxLIS = Math.max(maxLIS,result[i]);
                }
            }
        }
      return maxLIS;
    }
    //*********************************  Using Bottom-Up Approach *********************************//


    //*********************************   Using Patience Sorting Approach *********************************//
    public  int lengthOfLongestIncreasingSubsequencePatientSorting(int[] arr){

        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            int searchLowerBound = searchLowerBound(result,arr[i]);
            if(searchLowerBound == result.size()){
                result.add(arr[i]);
            }else{
               result.set(searchLowerBound,arr[i]);
            }
        }
        return result.size();
    }
    /* We want an increasing subsequence, and hence
    we want to eliminate the duplicates as well.
    lower_bound returns the index of next greater or equal to.*/

    public int searchLowerBound(List<Integer> result,int target){
       int left = 0;
       int right = result.size()-1;
       int lowerBoundIndex = result.size();

       while(left<=right){
          int mid = left+(right-left)/2;
          if(result.get(mid) < target){
              left = mid+1;
          }else{
              lowerBoundIndex = mid;
              right = mid-1;
          }
       }
       return lowerBoundIndex;
    }
    //*********************************   Using Patience Sorting Approach *********************************//

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int result = obj.lengthOfLongestIncreasingSubsequence(nums);
        System.out.println("Length of the longest strictly increasing subsequence-> " + result);

        int resultBottomUp = obj.lengthOfLongestIncreasingSubsequenceBottomUp(nums);
        System.out.println("Length of the longest strictly increasing subsequence-> " + resultBottomUp);

        int resultPatientSorting = obj.lengthOfLongestIncreasingSubsequencePatientSorting(nums);
        System.out.println("Length of the longest strictly increasing subsequence-> " + resultPatientSorting);
    }
}
