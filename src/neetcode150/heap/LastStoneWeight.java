package neetcode150.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);

        for(int i: stones){
            maxHeap.add(i);
        }

        while(maxHeap.size()>1){
            int a =  maxHeap.poll();
            int b = maxHeap.poll();
            if(a-b>0){
                maxHeap.add(a-b);
            }
        }
        if(maxHeap.size()>0){
            return maxHeap.peek();
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};

        LastStoneWeight obj = new LastStoneWeight();
        int result = obj.lastStoneWeight(stones);
        System.out.println(result);

    }
}
