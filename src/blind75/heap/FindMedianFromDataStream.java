package blind75.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

    Queue<Integer> leftMaxHeap = null;
    Queue<Integer> rightMinHeap = null;

    public FindMedianFromDataStream(){
        leftMaxHeap = new PriorityQueue<>(
                (a,b)-> b-a
        );
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num){

        if(leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()){
           leftMaxHeap.add(num);
       }else{
            rightMinHeap.add(num);
       }

        if(Math.abs(leftMaxHeap.size()-rightMinHeap.size())>1){
            rightMinHeap.add(leftMaxHeap.poll());
        }else if(leftMaxHeap.size() < rightMinHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian(){

        double result = 0;

        // for even no of element in the datastream
        if(leftMaxHeap.size()==rightMinHeap.size()){
            result = (double)(leftMaxHeap.peek() + rightMinHeap.peek())/2;
        }else{
       // for odd no of element in the datastream
         result =  leftMaxHeap.peek();
        }
        return result;
    }

    public static void main(String[] args){

        String[] operations = {"MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"};
        int[][] inputs = {{}, {1}, {2}, {}, {3}, {}};

        FindMedianFromDataStream obj =null;

        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("MedianFinder")){

                obj = new FindMedianFromDataStream();

            }else if(operations[i].equals("addNum")){

                int[] input = inputs[i];
                obj.addNum(input[0]);

            }else if(operations[i].equals("findMedian")){

                double result = obj.findMedian();
                System.out.print(result+" ");
            }
        }
    }
}
