package grind75.binary_search;

public class SearchInRotatedSortedArray {

    public int findIndexOfTargetElementInRotateSortedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target<nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(nums[mid]<=target && target<nums[high]){
                    low= mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,8,1,2,3};//{5,1,3};//{4,5,6,7,0,1,2};
        int target = 8;//0;

        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int result = obj.findIndexOfTargetElementInRotateSortedArray(nums,target);

        if(result>=0){
            System.out.println("Target is present at index "+result);
        }else{
            System.out.println("Target is not present in the Array");
        }
    }
}
