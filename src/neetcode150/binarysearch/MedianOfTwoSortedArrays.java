package neetcode150.binarysearch;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left = 0;
        int right = nums1.length;

        while(left<=right) {

            int totalNumberOfElementInSortedArray = (nums1.length + nums2.length);
            int noOfElementInLeftPortion = (left + right) / 2;
            int noOfElementInRightPortion = ((totalNumberOfElementInSortedArray+1)/2) - noOfElementInLeftPortion;

            int num1ArrayLeftMax = (noOfElementInLeftPortion == 0) ? Integer.MIN_VALUE : nums1[noOfElementInLeftPortion - 1];
            int num1ArrayRightMin = (noOfElementInLeftPortion == nums1.length) ? Integer.MAX_VALUE : nums1[noOfElementInLeftPortion];

            int num2ArrayLeftMax = (noOfElementInRightPortion == 0) ? Integer.MIN_VALUE : nums2[noOfElementInRightPortion - 1];
            int num2ArrayRightMin = (noOfElementInRightPortion == nums2.length) ? Integer.MAX_VALUE : nums2[noOfElementInRightPortion];

            if(num1ArrayLeftMax <= num2ArrayRightMin &&  num2ArrayLeftMax <= num1ArrayRightMin){
                if(totalNumberOfElementInSortedArray%2 !=0){ //odd number
                    return Math.max(num1ArrayLeftMax,num2ArrayLeftMax);
                }else{ //even Number
                    return (Math.max(num1ArrayLeftMax,num2ArrayLeftMax) + Math.min(num1ArrayRightMin,num2ArrayRightMin))/2.0;
                }
            }else if(num2ArrayLeftMax > num1ArrayRightMin){
                left = noOfElementInLeftPortion+1;
            }else{
                right = noOfElementInLeftPortion-1;
            }
        }
      return -1;
    }

    public static void main(String[] args){
        int[] nums1 = {2,4,9};
        int[] nums2 = {8,16,19,20};

        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        double result = obj.findMedianSortedArrays(nums1,nums2);
        System.out.print("Median is -> "+result);
    }
}
