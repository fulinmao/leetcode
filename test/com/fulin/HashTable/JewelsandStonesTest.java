package com.fulin.HashTable;

import org.junit.Test;

import static org.junit.Assert.*;

public class JewelsandStonesTest {

    @Test
    public void numJewelsInStones() {
        String[] inputJ = {"aA","z  "};
        String[] inputS = {"aAAbbbb","ZZ"};
        int[] result = {3,0};
        int errorCount = 0;
        for(int i=0;i<inputJ.length;i++){
            int rtn = JewelsandStones.numJewelsInStones(inputJ[i],inputS[i]);
            if(result[i] != rtn){
                System.out.println("输入J:"+inputJ[i] +",输入S:"+inputS[i] +",预期结果:"+result[i]+",实际结果："+rtn);
                errorCount ++;
            }
        }
        System.out.print("错误数量："+errorCount);
    }
}