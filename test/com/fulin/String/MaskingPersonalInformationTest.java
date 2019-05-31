package com.fulin.String;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaskingPersonalInformationTest {

    @Test
    public void maskPII() {
        String[] arr = {"LeetCode@LeetCode.com","AB@qq.com","1(234)567-890","86-(10)12345678"};
        String[] rtn = {"l*****e@leetcode.com","a*****b@qq.com","***-***-7890","+**-***-***-5678"};
        for(int i=0;i<arr.length;i++){
            String result = MaskingPersonalInformation.maskPII(arr[i]);
            System.out.println(arr[i]+"--"+result);
            assert result.equals(rtn[i]);
        }
    }
}