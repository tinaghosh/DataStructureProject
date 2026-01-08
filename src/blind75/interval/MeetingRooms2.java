package blind75.interval;

import java.util.Arrays;

public class MeetingRooms2 {

    public int noOfMeetingsRoomRequired(int[][] nums){

        int noOfMaxRoomRequired = 0;

        int[] startingPoints = Arrays.stream(nums).mapToInt(e->e[0]).toArray();
        Arrays.sort(startingPoints);
        Arrays.stream(startingPoints).forEach(e-> System.out.print(e+","));

        System.out.println();

        int[] endingPoints = Arrays.stream(nums).mapToInt(e->e[1]).toArray();
        Arrays.sort(endingPoints);
        Arrays.stream(endingPoints).forEach(e-> System.out.print(e+","));

        int startPointer = 0;
        int endPointer = 0;
        int count = 0;

        while(startPointer<startingPoints.length){
            if(startingPoints[startPointer] < endingPoints[endPointer]){
                count++;
                startPointer++;
            }else{
                endPointer++;
                count--;
            }
            noOfMaxRoomRequired = Math.max(count,noOfMaxRoomRequired);
        }
        return noOfMaxRoomRequired;
    }
    public static void main(String[] args){

       int[][] nums= {{0,40},{5,10},{15,20}};
       MeetingRooms2 obj = new MeetingRooms2();
       int result = obj.noOfMeetingsRoomRequired(nums);
       System.out.println("\nTotal no of rooms required to accommodate all the meetings are : "+result);

    }
}
