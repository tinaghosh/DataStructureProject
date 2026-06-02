package neetcode150.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
            while(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        KthLargestElementInAArray obj = new KthLargestElementInAArray();
        int result = obj.findKthLargest(nums,k);
        System.out.println(result);
    }
}
