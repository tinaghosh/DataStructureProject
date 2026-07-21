package neetcode150.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {

        int[] output = new int[queries.length];
        int[][] queriesWithIndex = new int[queries.length][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(int i=0;i<queries.length;i++){
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }

        Arrays.sort(intervals,(e1,e2)-> e1[0]-e2[0]);
        Arrays.sort(queriesWithIndex,(e1,e2)-> e1[0]-e2[0]);
        int i=0;

        for(int[] queryIndex : queriesWithIndex){

            int queryValue = queryIndex[0];
            int index = queryIndex[1];

            while(i<intervals.length && intervals[i][0] <= queryValue){
                queue.add(new int[]{intervals[i][1] -intervals[i][0] +1, intervals[i][1] });
                i++;
            }

            while(!queue.isEmpty() && queue.peek()[1] < queryValue){
                queue.poll();
            }
           output[index] = !queue.isEmpty()? queue.peek()[0]:-1;
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
        int[] queries = {2,19,5,22};

        MinimumIntervalToIncludeEachQuery obj = new MinimumIntervalToIncludeEachQuery();
        int[] result = obj.minInterval(intervals,queries);
        Arrays.stream(result).forEach(e-> System.out.print(e+" "));
    }
}
