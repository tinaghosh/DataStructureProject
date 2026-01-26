package blind75.array.two_pointer;

public class ContainerWithMostWater {

    public int maximumAreaWithWater(int[] height){

        int maxArea = Integer.MIN_VALUE;
        int leftPointer = 0;
        int rightPointer = height.length-1;

        while(leftPointer<=rightPointer){

            int area = (rightPointer-leftPointer) * Math.min(height[leftPointer],height[rightPointer]);
            maxArea = Math.max(maxArea,area);

            if(height[leftPointer]<=height[leftPointer]){
                leftPointer++;
            }else{
                rightPointer++;
            }
        }
      return maxArea;
    }
    public static void main(String[] args){

        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int result = obj.maximumAreaWithWater(height);
        System.out.println("MaxArea Containing most Water : "+result);

    }
}
