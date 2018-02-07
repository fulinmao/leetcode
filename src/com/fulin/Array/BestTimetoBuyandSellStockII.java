package com.fulin.Array;

/**
 * Created by fulin on 18-2-7.
 */
public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices == null ){
            return result;
        }

        for(int i=0;i<prices.length-1;i++){
            if(prices[i] < prices[i+1]){
                result += prices[i+1] - prices[i];
            }
        }

        return result;
    }
}
