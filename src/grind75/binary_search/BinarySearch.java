package grind75.binary_search;

public class BinarySearch {

    public int findElement(int[] nums, int target){

        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
               right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {5};//{-1,0,3,5,9,12};
        int target = 5; //9;//2;

        BinarySearch obj = new BinarySearch();
        int result = obj.findElement(nums,target);
        if(result>=0) {
            System.out.println(target + " exists in nums and its index is " + result);
        }else{
            System.out.println(target + " does not exist in nums so return -1 ");
        }
    }
}
