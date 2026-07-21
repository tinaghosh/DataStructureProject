package neetcode150.stack;

import java.util.Arrays;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
      int fleet =0;
      double prev =0;
      int[][] positionSpeedCombo = new int[position.length][2];

      for(int i=0;i<position.length;i++){
          positionSpeedCombo[i][0] = position[i];
          positionSpeedCombo[i][1] = speed[i];
      }
      Arrays.sort(positionSpeedCombo,(a, b)-> b[0]-a[0]);

      for(int i[]:positionSpeedCombo){
          double current = (double)(target - i[0])/i[1];
          if(current > prev){
              fleet++;
              prev = current;
          }
      }
      return fleet;
    }
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        CarFleet obj = new CarFleet();
        int fleetNo = obj.carFleet(target,position,speed);
        System.out.println(fleetNo);
    }
}
