package blind75.heap;

import java.util.*;

public class TopKFrequentElements {

    public int[] findtopKElement(int nums[] , int k){

     Map<Integer,Integer> fequencyMap = new HashMap<>();
     int[] output = new int[k];

     if(nums.length==k){
         return nums;
     }

     for(int i=0;i<nums.length;i++){
         int value = fequencyMap.getOrDefault(nums[i],0)+1;
         fequencyMap.put(nums[i],value);
     }

     Queue<Integer> heap = new PriorityQueue(
             (a,b)-> fequencyMap.get(a)- fequencyMap.get(b));

     for(int i:fequencyMap.keySet()){
         heap.add(i);
         if(heap.size()>k) {
             heap.poll();
         }
     }

     for(int i=0;i<k;i++){
         output[i] = heap.poll();
     }
     return output;
    }

    public static void main(String[] args){
        int nums[] = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequentElements obj = new TopKFrequentElements();
        int[] result = obj.findtopKElement(nums, k);
        Arrays.stream(result).forEach(e-> System.out.print(e+" "));
    }
}
