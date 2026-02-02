package blind75.array;

public class FindMinimumInRotatedSortedArray {

    public int findMinimumInRotatedSortedArray(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int result = nums[0];

        while (left <= right) {
            if (nums[left] < nums[right]) {
                result = Math.min(nums[left],result);
                break;
            } else {
                int mid = (left + right) / 2;
                result = Math.min(nums[mid],result);
                if (nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] input = {4,5,1,2,3};//{4,5,6,7,0,1,2};
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        int result = obj.findMinimumInRotatedSortedArray(input);
        System.out.println("The minimum element is in a rotated sorted array is :" + result);
    }
}
