package blind75.interval;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int noOfIntervalNeedToDeleteToMakeNonOverLapping(int[][] intervals){
        int delete = 0;
        Arrays.stream(intervals).forEach(e-> System.out.print("["+e[0]+","+e[1]+"]"));
        System.out.println("\n After sorting : ");
        Arrays.sort(intervals,(e1,e2)->e1[0]-e2[0]);
        Arrays.stream(intervals).forEach(e-> System.out.print("["+e[0]+","+e[1]+"]"));

        int[] currentInterval = intervals[0];

        for(int i=1;i<intervals.length;i++){

         int currentStart = currentInterval[0];
         int currentEnd = currentInterval[1];
         int nextStart = intervals[i][0];
         int nextEnd = intervals[i][1];

         if(currentStart<nextStart && currentEnd <= nextStart){
             currentInterval = intervals[i];
             continue;
         }else{
            delete++;
            currentInterval = new int[]{Math.min(currentStart,currentEnd),Math.min(nextStart,nextEnd)};
         }
        }
        return delete;
    }

    public static void main(String[] args){
        int[][] intervals = {{1,2},{1,2},{1,2}};//{{1,2},{2,3},{3,4},{1,3}};
        NonOverlappingIntervals obj = new NonOverlappingIntervals();
        int result = obj.noOfIntervalNeedToDeleteToMakeNonOverLapping(intervals);
        System.out.println("\nNo of interval we need to delete to make it non-overlapping intervals is -> "+result);

    }
}
