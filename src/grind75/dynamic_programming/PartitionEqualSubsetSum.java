package grind75.dynamic_programming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//
    int[][] memo;
    public boolean partitionPresentEqualToSubsetSum(int[] nums){

        int sum =0;
        for(int i : nums){
           sum = sum + i;
        }
        if(sum%2!=0){
            return false;
        }else{
            int eachSubsetSum = sum / 2;

            memo = new int[nums.length+1][eachSubsetSum+1];
            Arrays.stream(memo).forEach(e->{
                Arrays.fill(e,-1);
            });

            if(recursion(nums,eachSubsetSum,0)){
                return true;
            }
        }
        return false;
    }
    public boolean recursion(int[] nums,int eachSubsetSum,int index){
        if(eachSubsetSum == 0){
            return true;
        }
        if(index>= nums.length){
            return false;
        }
        if(memo[index][eachSubsetSum] != -1){
            return memo[index][eachSubsetSum]==1;
        }

        boolean taken = false;
        if(nums[index]<=eachSubsetSum){
            taken = recursion(nums,eachSubsetSum-nums[index],index+1);
        }
        boolean notTaken =  recursion(nums,eachSubsetSum,index+1);

        memo[index][eachSubsetSum] =  (taken || notTaken) ? 1:0;
        return taken || notTaken;
    }
    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//

    public boolean partitionPresentEqualToSubsetSumBottomUp(int[] nums){

        int sum =0;
        for(int i : nums){
            sum = sum + i;
        }
        if(sum%2!=0){
            return false;
        }else{
            int eachSubsetSum = sum / 2;
            if(bottomUpPartition(nums,eachSubsetSum)){
                return true;
            }
        }
        return false;
    }

    public boolean bottomUpPartition(int[] nums,int eachSubsetSum){
        boolean[][] result = new boolean[nums.length+1][eachSubsetSum+1];

        // It's not possible to get any sum when we have no elements
        for(int i=0;i<result[0].length;i++){
            result[0][i] = false;
        }

        //It's always initial subset sum=0
        for(int i=0;i<result.length;i++){
            result[i][0] = true;
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<eachSubsetSum+1;j++){
                if(nums[i-1]<=j){
                    result[i][j] = result[i-1][j-nums[i-1]] || result[i-1][j]; //Taken
                }else{
                    result[i][j] = result[i-1][j];  //not Taken as the subset sum is less than the num[i]
                }
            }
        }
        return result[nums.length][eachSubsetSum];
    }
    //*********************************  Using Bottom-Up Approach *********************************//

    //*********************************  Using Bottom-Up Optimized Approach *********************************//

    public boolean partitionPresentEqualToSubsetSumBottomUpOptimized(int[] nums){

        int sum =0;
        for(int i : nums){
            sum = sum + i;
        }
        if(sum%2!=0){
            return false;
        }else{
            int eachSubsetSum = sum / 2;
            boolean[] dp = new boolean[eachSubsetSum+1];
            dp[0] = true;

            for(int i=0;i<nums.length;i++){
                for(int j=eachSubsetSum ; j>=nums[i];j--){
                    boolean notTaken = dp[j] ;
                    boolean taken = dp[j-nums[i]];
                    dp[j] = notTaken || taken;
                }
            }
            return dp[eachSubsetSum];
        }
    }

    //*********************************  Using Bottom-Up Optimized Approach *********************************//
    public static void main(String[] args){
        int[] nums = {1,5,11,5};

        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        boolean result = obj.partitionPresentEqualToSubsetSum(nums);
        if(result){
            System.out.println("sum of the elements in both subsets is equal");
        }else{
            System.out.println("sum of the elements in both subsets is not equal");
        }

        boolean resultBottomUP = obj.partitionPresentEqualToSubsetSumBottomUp(nums);
        if(resultBottomUP){
            System.out.println("sum of the elements in both subsets is equal");
        }else{
            System.out.println("sum of the elements in both subsets is not equal");
        }

        boolean resultBottomUPOptimized = obj.partitionPresentEqualToSubsetSumBottomUpOptimized(nums);
        if(resultBottomUPOptimized){
            System.out.println("sum of the elements in both subsets is equal");
        }else{
            System.out.println("sum of the elements in both subsets is not equal");
        }
    }
}
