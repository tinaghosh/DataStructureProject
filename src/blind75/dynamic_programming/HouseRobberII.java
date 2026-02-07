package blind75.dynamic_programming;

import java.util.Arrays;

public class HouseRobberII {

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    int[] mem1;
    int[] mem2;

    public int maxMoneyCanRob(int[] houses) {

        if (houses.length == 0) {
            return 0;
        }

        if (houses.length == 1)
            return houses[0];

        if (houses.length == 2)
            return Math.max(houses[0], houses[1]);

        mem1 = new int[houses.length];
        Arrays.fill(mem1, -1);

        mem2 = new int[houses.length];
        Arrays.fill(mem2, -1);

        int incluingStartIndex = recursion(houses, 0, houses.length - 1, mem1);
        int excludingStartIndex = recursion(houses, 1, houses.length, mem2);

        return  Math.max(incluingStartIndex, excludingStartIndex);
    }

    public int recursion(int[] houses, int index, int endIndex, int[] mem) {

        if (index >= endIndex) {
            return 0;
        }
        if (mem[index] != -1) {
            return mem[index];
        }

        int taken = houses[index] + recursion(houses, index + 2, endIndex, mem);
        int notTaken = recursion(houses, index + 1, endIndex, mem);

        mem[index] = Math.max(taken, notTaken);

        return mem[index];
    }
    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//
    public int maxMoneyCanRobBottomUp(int[] houses) {

        int[] result = new int[houses.length + 1];

        result[0] = 0;
        int incluingStartIndex;
        int excludingStartIndex;

        for (int i = 1; i <= houses.length - 1; i++) {
            if (i - 2 < 0) {
                int taken = houses[i - 1] + 0;
                int notTaken = result[i - 1];
                result[i] = Math.max(taken, notTaken);
            } else {
                int taken = houses[i - 1] + result[i - 2];
                int notTaken = result[i - 1];
                result[i] = Math.max(taken, notTaken);
            }
        }
        incluingStartIndex = result[houses.length - 1];
        Arrays.fill(result, 0);

        for (int i = 2; i <= houses.length; i++) {
            int taken = houses[i - 1] + result[i - 2];
            int notTaken = result[i - 1];

            result[i] = Math.max(taken, notTaken);
        }
        excludingStartIndex = result[houses.length];

        return Math.max(incluingStartIndex, excludingStartIndex);
    }
    //*********************************  Using Bottom-Up Approach *********************************//


    //*************************  Using Approach-3 (Space Optimized Bottom Up) ********************//

    public int maxMoneyCanRobBottomUpSpaceOptimized(int[] houses) {


        int prevPrev = 0;
        int prev = 0;
        int maxMoneyIncluingStartIndex = 0;
        int maxMoneyExcludingStartIndex = 0;

        for (int i = 1; i <= houses.length - 1; i++) {
            int taken = houses[i - 1] + prevPrev;
            int notTaken = prev;
            maxMoneyIncluingStartIndex = Math.max(taken, notTaken);
            prevPrev = prev;
            prev = maxMoneyIncluingStartIndex;

        }

        prevPrev = 0;
        prev = 0;

        for (int i = 2; i <= houses.length; i++) {
            int taken = houses[i - 1] + prevPrev;
            int notTaken = prev;
            maxMoneyExcludingStartIndex = Math.max(taken, notTaken);
            prevPrev = prev;
            prev = maxMoneyExcludingStartIndex;
        }

        return Math.max(maxMoneyIncluingStartIndex, maxMoneyExcludingStartIndex);
    }

    //*************************  Using Approach-3 (Space Optimized Bottom Up) ********************//


    public static void main(String[] args) {

        int[] houses = {1, 2, 3};
        HouseRobberII obj = new HouseRobberII();

        int resultRecursion = obj.maxMoneyCanRob(houses);
        System.out.println(" Maximum amount of money can be robbed tonight without alerting the police -> " + resultRecursion);

        int resultBottomUp = obj.maxMoneyCanRobBottomUp(houses);
        System.out.println(" Maximum amount of money can be robbed tonight without alerting the police -> " + resultBottomUp);

        int resultBottomUpSpaceOptimized = obj.maxMoneyCanRobBottomUpSpaceOptimized(houses);
        System.out.println(" Maximum amount of money can be robbed tonight without alerting the police -> " + resultBottomUpSpaceOptimized);

    }
}
