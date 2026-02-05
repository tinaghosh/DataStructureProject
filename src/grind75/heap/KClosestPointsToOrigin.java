package grind75.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    public int[][] findKclosestPoints(int[][] points, int k){
        int[][] result = new int[k][2];

        // As we need to figure out closest points so basically top k
        // shortest distance number hence use maxHeap

        Queue<int[]> maxHeap = new PriorityQueue<>(
                (a,b)-> Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1])
        );

        for (int[] i : points){
            maxHeap.add(i);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        for(int i=0;i<k;i++){
            result[i] =  maxHeap.poll();
        }
     return result;
    }

    public static  void main(String[] args){
        int[][] points = {{-5,4},{-6,-5},{4,6}}; //{{3,3},{5,-1},{-2,4}};
        int k = 2;
        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();
        int[][] result = obj.findKclosestPoints(points,k);
        Arrays.stream(result).forEach(e-> System.out.println(e[0]+" "+e[1]));
    }
}
