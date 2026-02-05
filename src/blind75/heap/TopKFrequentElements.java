package blind75.heap;

import java.util.*;

public class TopKFrequentElements {

    public int[] findtopKElement(int[] nums , int k){

     Map<Integer,Integer> fequencyMap = new HashMap<>();
     int[] output = new int[k];

     if(nums.length==k){
         return nums;
     }

     for(int i : nums){
         int value = fequencyMap.getOrDefault(i,0)+1;
         fequencyMap.put(i,value);
     }

     // As we need to figure out top highest frequency so basically top k
        // largest frequent number hence use minHeap

     Queue<Integer> heap = new PriorityQueue(
             (a,b)-> fequencyMap.get(a)- fequencyMap.get(b));

     for(int i:fequencyMap.keySet()){
         heap.add(i);
         if(heap.size()>k) {
             heap.poll();
         }
     }

     for(int i=0;i<k;i++){
         if(!heap.isEmpty())
             output[i] = heap.poll();
     }
     return output;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        TopKFrequentElements obj = new TopKFrequentElements();
        int[] result = obj.findtopKElement(nums, k);
        Arrays.stream(result).forEach(e-> System.out.print(e+" "));
    }
}
