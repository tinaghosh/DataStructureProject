package blind75.dynamic_programming;

import java.util.Arrays;

public class ClimbingStairs {

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//
    int[] mem;

    public int distinctPathToClimbingStairs(int numOfStairs) {
        mem = new int[numOfStairs + 1];
        Arrays.fill(mem, -1);
        return recursion(numOfStairs);
    }

    public int recursion(int numOfStairs) {

        if (numOfStairs == 0) {
            return 1;
        }
        if (numOfStairs < 0) {
            return 0;
        }
        if (mem[numOfStairs] != -1) {
            return mem[numOfStairs];
        }

        int climbing1Step = recursion(numOfStairs - 1);
        int climbing2Step = recursion(numOfStairs - 2);

        mem[numOfStairs] = climbing1Step + climbing2Step;
        return mem[numOfStairs];
    }
    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//

    public int distinctPathToClimbingStairsUsingBottomUp(int numOfStairs) {

        int[] result = new int[numOfStairs + 1];

        if (numOfStairs <= 2) {
            return numOfStairs;
        }
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= numOfStairs; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[numOfStairs];
    }
    //*********************************  Using Bottom-Up Approach *********************************//

    //*************************  Using Approach-3 (Space Optimized Bottom Up) ********************//

    public int distinctPathToClimbingStairsUsingBottomUpSpaceOptimized(int numOfStairs) {

        if (numOfStairs <= 2) {
            return numOfStairs;
        }
        int count = 0;
        int oneStep = 1;
        int twoStep = 2;

        for (int i = 3; i <= numOfStairs; i++) {
            count = oneStep + twoStep;
            oneStep = twoStep;
            twoStep = count;
        }
        return count;
    }
    //*************************  Using Approach-3 (Space Optimized Bottom Up) ********************//

    public static void main(String[] args) {
        int n = 5;
        ClimbingStairs obj = new ClimbingStairs();

        int result = obj.distinctPathToClimbingStairs(n);
        System.out.println("Distinct ways can you climb to the top -> " + result);

        int resultBottomUp = obj.distinctPathToClimbingStairsUsingBottomUp(n);
        System.out.println("Distinct ways can you climb to the top -> " + resultBottomUp);

        int resultBottomUpSpaceOptimized = obj.distinctPathToClimbingStairsUsingBottomUpSpaceOptimized(n);
        System.out.println("Distinct ways can you climb to the top -> " + resultBottomUpSpaceOptimized);
    }
}
