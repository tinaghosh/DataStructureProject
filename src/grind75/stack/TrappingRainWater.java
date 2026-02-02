package grind75.stack;

import java.util.Arrays;

public class TrappingRainWater {

    //Using Two Pointer Method
    public int trapWaterUsingTwoPointer(int[] height){
        int waterSum = 0;
        int leftPointer = 0;
        int rightPointer = height.length-1;
        int maxLeft= height[leftPointer];
        int maxRight = height[rightPointer];

        while(leftPointer < rightPointer){
            if(height[leftPointer]<height[rightPointer]){
                if(maxLeft - height[leftPointer] > 0) {
                    waterSum = waterSum + (maxLeft - height[leftPointer]);
                }else{
                    waterSum = waterSum+0; //Negative value will be replaced by 0
                }
                maxLeft = Math.max(height[leftPointer],maxLeft);
                leftPointer++;
            }else{

                if(maxRight - height[rightPointer] > 0) {
                    waterSum = waterSum + (maxRight - height[rightPointer]);
                }else{
                    waterSum = waterSum+0;
                }
                maxRight = Math.max(height[rightPointer],maxRight);
                rightPointer--;
            }
        }
        return waterSum;
    }

    //Taking extra array Memory and calculate
    public int trapWaterUsingExtraArrayMemory(int[] height){

        int[] waterSumArray = new int[height.length];
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLeftRight = new int[height.length];

        int maxLeftValue = height[0];
        int maxRightValue = height[height.length-1];
        int waterSum=0;

        for(int i=0;i<height.length;i++){
            maxLeftValue = Math.max(height[i],maxLeftValue);
            maxLeft[i] = maxLeftValue;
        }
        Arrays.stream(maxLeft).forEach(e->System.out.print(e+" "));
        System.out.println();

        for(int i=height.length-1;i>=0;i--){
            maxRightValue = Math.max(height[i],maxRightValue);
            maxRight[i] = maxRightValue;
        }
        Arrays.stream(maxRight).forEach(e->System.out.print(e+" "));
        System.out.println();

        for(int i=0;i<height.length;i++){
            minLeftRight[i] = Math.min(maxLeft[i],maxRight[i]);
        }
        Arrays.stream(minLeftRight).forEach(e->System.out.print(e+" "));
        System.out.println();

        for(int i=0;i<height.length;i++){
            if(minLeftRight[i]-height[i]>0) {
                waterSumArray[i] = minLeftRight[i] - height[i];
            }else{
                waterSumArray[i] = 0;
            }
        }
        Arrays.stream(waterSumArray).forEach(e->System.out.print(e+" "));
        System.out.println();

        for(int i=0;i<waterSumArray.length;i++){
            waterSum= waterSum + waterSumArray[i];
        }

        return waterSum;
    }

    public static void main(String[] args){

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater obj = new TrappingRainWater();
        int result = obj.trapWaterUsingTwoPointer(height);
        System.out.println(" Total units of rain water are being trapped: "+result);
        int result1 = obj.trapWaterUsingExtraArrayMemory(height);
        System.out.println(" Total units of rain water are being trapped: "+result1);
    }
}
