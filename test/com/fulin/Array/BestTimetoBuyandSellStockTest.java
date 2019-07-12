package com.fulin.Array;

import com.fulin.Utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 毛福林
 * @title: BestTimetoBuyandSellStockTest
 * @projectName leetcode
 * @description: TODO
 * @date 2019/7/1221:30
 */
public class BestTimetoBuyandSellStockTest {

    @Test
    public void maxProfit() {
        int[][] prices = {{7,1,5,3,6,4},{7,6,4,3,1}};
        int[] result = {5,0};
        float errorCount = 0.0F;
        for(int i=0;i< prices.length;i++){
            int rtn = BestTimetoBuyandSellStock.maxProfit(prices[i]);
            if(rtn != result[i]){
                errorCount ++;
                ArrayUtils.printArray(prices[i]);
                System.out.println("rtn:"+rtn+",result="+result);
            }
        }
        assert  errorCount/prices.length == 0.0;
    }
}