package blind75.array.dynamicprogramming;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices){
       int maxProfit = 0;
       int minPrice = prices[0];
       for(int i=1;i<prices.length;i++){
           maxProfit = Math.max(maxProfit,prices[i] - minPrice);
           minPrice = Math.min(minPrice,prices[i]);
       }
       return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        int result = obj.maxProfit(prices);
        System.out.println("Max Profit can be -> "+result);
    }
}
