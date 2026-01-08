package blind75.interval;

import java.util.Arrays;

public class MeetingRooms {

    public boolean canPersonAttendAllMeeting(int[][] nums){

        Arrays.sort(nums,(e1,e2)-> e1[0]-e2[0]);

        System.out.println("After Sorting intervals based on starts element:");
        Arrays.stream(nums).forEach(e->System.out.println("["+e[0]+","+e[1]+"]"));

        for(int i=0;i<nums.length-1;i++){

            int currentIntervalEnd = nums[i][1];
            int nextIntervalStart = nums[i+1][0];

            if(currentIntervalEnd>nextIntervalStart){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){

       int[][] meetings ={{5,8},{9,15}};// {{0,30},{5,10},{15,20}};

        MeetingRooms obj = new MeetingRooms();

        boolean result = obj.canPersonAttendAllMeeting(meetings);
        if(result){
            System.out.println("A person can attend all the meetings");
        }else{
            System.out.println("A person can't attend all the meetings");
        }

    }
}
