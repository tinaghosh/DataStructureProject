package blind75.dynamic_programming;

import java.util.Arrays;

public class HouseRobber {

    //************************  Using Recursion + Memo (Top-Down Approach) ************************//
    int[] mem;

    public int maxMoneyCanRob(int[] houses) {
        mem = new int[houses.length];
        Arrays.fill(mem, -1);

        if (houses.length > 0) {
            return recursion(houses, 0);
        } else {
            return 0;
        }
    }

    public int recursion(int[] houses, int index) {
        if (index >= houses.length) {
            return 0;
        }
        if (mem[index] != -1) {
            return mem[index];
        }
        int taken = houses[index] + recursion(houses, index + 2);
        int notTaken = recursion(houses, index + 1);

        mem[index] = Math.max(taken, notTaken);
        return mem[index];
    }
    //************************  Using Recursion + Memo (Top-Down Approach) ************************//

    //*********************************  Using Bottom-Up Approach *********************************//
    public int maxMoneyCanRobBottomUp(int[] houses) {

        if (houses.length == 0) {
            return 0;
        } else if (houses.length == 1) {
            return houses[0];
        } else {

            int n = houses.length;
            int[] result = new int[n + 1];

            result[0] = 0; // till 0th home no money has been robbed.
            result[1] = houses[1 - 1]; // till 1st home money has been robbed houses[i-1].

            for (int i = 2; i <= houses.length; i++) {
       /*
         notTaken  : If we skip this house,  then we have money till previous house  =  t[i-1]
         Taken : If we steal this house, then we can't take prev profit, we can take till (i-2)th house profit = t[i-2]
      */
                int taken = houses[i - 1] + result[i - 2];
                int notTaken = result[i - 1];
                result[i] = Math.max(taken, notTaken);
            }
            return result[n]; //result[n] means Maximum money robbed till nth house.
        }
    }
    //*********************************  Using Bottom-Up Approach *********************************//


    //*************************  Using Approach-3 (Space Optimized Bottom Up) ********************//

    public int maxMoneyCanRobBottomUpSpaceOptimized(int[] houses) {

        if (houses.length == 0) {
            return 0;
        } else if (houses.length == 1) {
            return houses[0];
        } else {
            int maxMoney = 0;
            int prevPrev = 0; // till 0th home no money has been robbed.
            int prev = houses[0]; // till 1st home money has been robbed houses[i-1].

            for (int i = 2; i <= houses.length; i++) {
                int taken = houses[i - 1] + prevPrev;
                int notTaken = prev;
                maxMoney = Math.max(taken, notTaken);
                prevPrev = prev;
                prev = maxMoney;
            }
            return maxMoney;
        }
    }

    //*************************  Using Approach-3 (Space Optimized Bottom Up) ********************//
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};
        HouseRobber obj = new HouseRobber();

        int resultRecursion = obj.maxMoneyCanRob(houses);
        System.out.println(" Maximum amount of money can be robbed tonight without alerting the police -> " + resultRecursion);

        int resultBottomUp = obj.maxMoneyCanRobBottomUp(houses);
        System.out.println(" Maximum amount of money can be robbed tonight without alerting the police -> " + resultBottomUp);

        int resultBottomUpSpaceOptimized = obj.maxMoneyCanRobBottomUpSpaceOptimized(houses);
        System.out.println(" Maximum amount of money can be robbed tonight without alerting the police -> " + resultBottomUpSpaceOptimized);

    }
}
