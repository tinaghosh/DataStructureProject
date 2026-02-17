package blind75.dynamic_programming;


import java.util.Arrays;

public class CoinChange {

    public int SumOfMinCoins(int[] coins, int amount){
       int[][] dp = new int[coins.length+1][amount+1];

        for(int i=0;i<=coins.length;i++){
            Arrays.fill(dp[i], amount + 1);
        }

       for(int i=0;i<=coins.length;i++){
           dp[i][0] = 0;
       }

       for(int i=1;i<=coins.length;i++) {
           for (int j = 1; j <= amount; j++) {
             dp[i][j] = dp[i-1][j]; // Not Take
             if(coins[i-1] <= j) { // Take
                 dp[i][j] =  Math.min(dp[i][j], (1 + dp[i][j - coins[i-1]]));
             }
           }
       }
      return dp[coins.length][amount]>amount ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 11;

        CoinChange obj = new CoinChange();
        int result = obj.SumOfMinCoins(coins,amount);
        System.out.println("Fewest number of coins that you need to make up that amount -> "+result);
    }
}
