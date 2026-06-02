package neetcode150.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

    Queue<Integer> minHeap ;
    int k ;

    public KthLargestElementInAStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {

        String[] operations = {"KthLargest", "add", "add", "add", "add", "add"};
        int[] intialStreamInputs = {4, 5, 8, 2};
        int k=3;
        int[] inputArray = {3, 5, 10, 9, 4};

        KthLargestElementInAStream obj = new KthLargestElementInAStream(k,intialStreamInputs);
        List<Object> resultArray = new ArrayList<>();

        for(int i=0;i<inputArray.length;i++){
            int result = obj.add(inputArray[i]);
            resultArray.add(result);
        }
        resultArray.forEach(e->System.out.print(e+" "));
   }
}
