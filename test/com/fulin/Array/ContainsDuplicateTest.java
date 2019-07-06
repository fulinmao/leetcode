package com.fulin.Array;

import com.fulin.Utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {

    @Test
    public void containsDuplicate() {
        int[][] nums = {{1,2,3,1},{1,2,3,4},{1,1,1,3,3,4,3,2,4,2}};
        boolean[] result = {true,false,true};
        float errorCount = 0.0f;
        for(int i=0;i<nums.length;i++){
            boolean rtn = ContainsDuplicate.containsDuplicate(nums[i]);
            if(rtn != result[i]){
                System.out.println("=======================================");
                ArrayUtils.printArray(nums[i]);
                System.out.print("result:" + rtn);
                System.out.println("=======================================");
                errorCount ++;

            }
        }
        float errorRate = errorCount / nums.length;
        System.out.println("错误率："+errorCount / nums.length);
        assert  errorRate == 0.0;
    }
}