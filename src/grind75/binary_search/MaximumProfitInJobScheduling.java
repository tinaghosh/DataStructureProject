package grind75.binary_search;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    private int[] memo ;
    public int jobScheduling(int[] startTime,int[] endTime,int[] profit){

       Job[] jobDetails = new Job[startTime.length];
       memo = new int[startTime.length];
       Arrays.fill(memo, -1);

       for(int i=0;i<startTime.length;i++){
           jobDetails[i] = new Job(startTime[i],endTime[i],profit[i]);
       }
       //Sort jobs based on start Time.
       Arrays.sort(jobDetails,(e1,e2)->e1.startTime-e2.startTime);
       return calculateMaxProfit(jobDetails,0);
    }

    public int calculateMaxProfit(Job[] jobDetails, int i){

        if(i>=jobDetails.length){
            return 0;
        }

        if (memo[i] != -1)
            return memo[i];

        int getNextJobDetails = getNextJobDetails(jobDetails,i+1,jobDetails[i].endTime);
        int taken = jobDetails[i].profit + calculateMaxProfit(jobDetails,getNextJobDetails);
        int notTaken = calculateMaxProfit(jobDetails,i+1);

        memo[i] = Math.max(taken, notTaken);
        return memo[i];
    }

    public int getNextJobDetails(Job[] jobDetails , int searchStartingPoint , int currentEndTime){

        int left = searchStartingPoint;
        int right = jobDetails.length-1;
        int result = jobDetails.length+1;

        while(left <= right){
            int mid = left+(right-left)/2;
            if(jobDetails[mid].startTime >= currentEndTime){
                result = mid;
                right = mid -1;
            }else{
               left = mid+1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};

        MaximumProfitInJobScheduling obj = new MaximumProfitInJobScheduling();
        int result = obj.jobScheduling(startTime,endTime,profit);
        System.out.println("Maximum Profit -> "+result);

    }

    class Job{
        int startTime;
        int endTime;
        int profit;

        Job(int startTime,int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
