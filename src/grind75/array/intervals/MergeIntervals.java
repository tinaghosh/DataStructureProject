package grind75.array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] mergeIntervals(int[][] intervals){

        Arrays.sort(intervals, (e1, e2)->e1[0]-e2[0]);
        System.out.println("Sorting based on intervals starting points");
        Arrays.stream(intervals).forEach(e-> System.out.print("["+e[0]+"----"+e[1]+"]"));

        List<int[]> listOutput = new ArrayList<>();
        int[] currentInterval = intervals[0];
        listOutput.add(currentInterval);

        for(int i=1;i<intervals.length;i++){

            currentInterval = listOutput.getLast();

            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(currentEnd>=nextStart){
                currentInterval[1] = Math.max(currentEnd,nextEnd);
            }else{
                listOutput.add(intervals[i]);
            }
        }
        return listOutput.toArray(int[][]::new);
    }
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();
        int[][] results = obj.mergeIntervals(intervals);
        System.out.println();
        Arrays.stream(results).forEach(e-> System.out.print("["+e[0]+"----"+e[1]+"]"));
    }
}
