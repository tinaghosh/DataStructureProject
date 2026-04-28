package general.array;


public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices){
        int profit = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i]> prices[i-1]){
                profit = profit + (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStockII obj = new BestTimeToBuyAndSellStockII();
        int result = obj.maxProfit(prices);
        System.out.println("Max Profit can be -> "+result);
    }
}
