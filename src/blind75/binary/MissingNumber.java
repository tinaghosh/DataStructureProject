package blind75.binary;

public class MissingNumber {

    public int findMissingNo(int[] nums){

        int n = nums.length;
        int expectedSum = (n*(n+1))/2;
        int calculateSum = 0;

        for(int i : nums){
            calculateSum = calculateSum + i;
        }
        return expectedSum-calculateSum;
    }

    public static void main(String[] args){
        int[] nums = {3,0,1};
        MissingNumber obj = new MissingNumber();
        int result = obj.findMissingNo(nums);
        System.out.println("Missing No is :"+result);
    }
}
