package com.fulin.String;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotReturnToOriginTest {

    @Test
    public void judgeCircle() {

        String[] input = {"UD","LL"};
        boolean[] result = {true,false};

        for(int i=0;i< input.length;i++){
            boolean  rtn  = RobotReturnToOrigin.judgeCircle(input[i]);
            System.out.print(rtn);
            assert result[i] == rtn;
        }
    }
}