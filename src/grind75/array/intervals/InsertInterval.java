package grind75.array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insertAndMergeInterval(int[][] intervals, int[] newInterval) {

        List<int[]> output = new ArrayList<>();
        int indicator = 0;

        while(indicator<intervals.length && intervals[indicator][0]<newInterval[0]){
           output.add(intervals[indicator]);
           indicator++;
        }

        if(output.size()>0){
            if(output.getLast()[1] >= newInterval[0]){
                output.getLast()[0] = Math.min(output.getLast()[0],newInterval[0]);
                output.getLast()[1] = Math.max(output.getLast()[1],newInterval[1]);
            }else{
                output.add(newInterval);
            }
        }else{
            output.add(newInterval);
        }

        for(int i = indicator;i<intervals.length;i++){
            if(output.getLast()[1] >= intervals[i][0]){
                output.getLast()[0] = Math.min(output.getLast()[0],intervals[i][0]);
                output.getLast()[1] = Math.max(output.getLast()[1],intervals[i][1]);
            }else{
                output.add(intervals[i]);
            }
        }
        return output.toArray(int[][]::new);
    }
    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {3, 4}, {5, 8}, {9, 15}};// {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {2, 5};// {4,8};

        InsertInterval obj = new InsertInterval();
        int[][] result = obj.insertAndMergeInterval(intervals, newInterval);
        Arrays.stream(result).forEach(e -> System.out.print("[" + e[0] + "," + e[1] + "]"));
    }
}
