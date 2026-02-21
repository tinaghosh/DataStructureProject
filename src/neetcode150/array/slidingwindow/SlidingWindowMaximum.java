package neetcode150.array.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maximumNumberFromEachKLengthSlidingWindow(int[] nums,int k){

        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<nums.length;i++){

          //Index out of range delete from queue
          while(!deque.isEmpty() && deque.getFirst() < i-k+1){
              deque.poll();
          }
          //Maximum element always in the first element of the queue So delete all the less element  from fromt of the queue
          while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
             deque.pollLast();
          }
          //Add element in the queue
          deque.add(i);

          //Add the front element in th eresult
          if(i >= k-1){
              result[i-k+1]= nums[deque.getFirst()];
          }
        }
        return result;
    }
    public static void main(String args[]){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] result = obj.maximumNumberFromEachKLengthSlidingWindow(nums,k);
        Arrays.stream(result).forEach(e-> System.out.print(e+","));
    }
}
