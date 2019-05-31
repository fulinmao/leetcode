package com.fulin.BitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class HammingDistanceTest {

    @Test
    public void hammingDistance() {
        int x = 1;
        int y = 4;
        int rtn = 2;
        int result = HammingDistance.hammingDistance(x,y);
        System.out.print(result);
        assert result == rtn;
    }
}