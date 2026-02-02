package blind75.array.two_pointer;

public class MaximumSubarray {

    public int maximumSubArray(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int rightPointer = 0;rightPointer<arr.length;rightPointer++){
            currentSum = currentSum + arr[rightPointer];
            maxSum = Math.max(currentSum,maxSum);

            if(currentSum<0){
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        int[] i = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray obj = new MaximumSubarray();
        int result = obj.maximumSubArray(i);
        System.out.println("Sum of the subArray with the largest Sum :"+result);
    }
}
