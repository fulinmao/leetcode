package com.fulin.Array;

/**
 * Created by fulin on 18-2-7.
 */
public class BestTimetoBuyandSellStock {

    public static void main(String[] args){
        int[] prices = {2,4,1};
        int result = maxProfit(prices);
        System.out.print(result);
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        if(prices == null || prices.length == 0){
            return result;
        }

        int buy = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            buy = Math.min(buy,prices[i]);
            result = Math.max(result,prices[i] - buy);
        }
        return result;
    }
}
