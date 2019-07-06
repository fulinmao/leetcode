package com.fulin.Array;

import com.fulin.Utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 毛福林
 * @title: ContainsDuplicateIIITest
 * @projectName leetcode
 * @description: TODO
 * @date 2019/7/622:04
 */
public class ContainsDuplicateIIITest {

    @Test
    public void containsNearbyAlmostDuplicate() {
        int[][] nums = {{-1,2147483647},{1,2,3,1},{1,0,1,1},{1,5,9,1,5,9}};
        int[] kArray = {1,3,1,2};
        int[] tArray = {2147483647,0,2,3};
        boolean[]    result = {false,true,true,false};
        float errorCount = 0.0F;
        for(int i=0;i<nums.length;i++){
            boolean rtn = ContainsDuplicateIII.containsNearbyAlmostDuplicate(nums[i],kArray[i],tArray[i]);
            if(rtn != result[i]){
                System.out.println("=======================================");
                ArrayUtils.printArray(nums[i]);
                System.out.print("K = " + kArray[i] + ",t = "+tArray[i] +",result:" + rtn);
                System.out.println();
                System.out.println("=======================================");
                errorCount ++;

            }
        }

        float errorRate = errorCount / nums.length;
        System.out.println("错误率："+errorCount / nums.length);
        assert  errorRate == 0.0;
    }
}