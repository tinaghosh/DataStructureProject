package neetcode150.bitmanipulation;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int c = 0;
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            c = a ^ c ;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        SingleNumber obj = new SingleNumber();
        int result = obj.singleNumber(nums);
        System.out.println(result);
    }
}
