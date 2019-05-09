package com.fulin.number;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyStringsTest {

    @Test
    public void multiply() {
        String num1 = "123";
        String num2 = "456";

        String result = MultiplyStrings.multiply(num1,num2);
        System.out.println(result);
        assert  "56088".equals(result);

    }
}