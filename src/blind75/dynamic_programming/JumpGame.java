package blind75.dynamic_programming;

public class JumpGame {

    public boolean possibleReachingLastIndex(int[] nums){

        int goal = nums.length-1;

        for(int i=nums.length-2;i>=0;i--){
            if((nums[i]+i) >= goal){
                goal =i;
            }
        }
        if(goal == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[]  nums = {3,2,1,0,4};//{2,3,1,1,4};
        JumpGame  obj = new JumpGame();
        boolean result = obj.possibleReachingLastIndex(nums);
        if(result){
            System.out.println("Yes It's possible to reach last index");
        }else{
            System.out.println("No It's not possible to reach last index");
        }
    }
}
