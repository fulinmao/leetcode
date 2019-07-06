package com.fulin.Array;

import com.fulin.Utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateIITest {

    @Test
    public void containsNearbyDuplicate() {
        int[][] nums = {{1,2,3,1},{1,0,1,1},{1,2,3,1,2,3}};
        boolean[] result = {true,true,false};
        int[] kArray = {3,1,2};
        float errorCount = 0.0f;
        for(int i=0;i<nums.length;i++){
            boolean rtn = ContainsDuplicateII.containsNearbyDuplicate(nums[i],kArray[i]);
            if(rtn != result[i]){
                System.out.println("=======================================");
                ArrayUtils.printArray(nums[i]);
                System.out.print("K = " + kArray[i] + ",result:" + rtn);
                System.out.println("=======================================");
                errorCount ++;

            }
        }
        float errorRate = errorCount / nums.length;
        System.out.println("错误率："+errorCount / nums.length);
        assert  errorRate == 0.0;
    }
}