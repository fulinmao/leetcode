package com.fulin.number;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidNumberTest {

    @Test
    public void isNumber() {
        String[] str = {"0"," 0.1 ","abc" ,"1 a","2e10"," -90e3   "," 1e","e3" ," 6e-1"," 99e2.5 ","53.5e93"," --6 ","-+3","95a54e53","e"," ","0....","3.",".1","4e+","7e69e"};
        boolean[] resultArr = {true,true,false,false,true,true,false,false,true,false,true,false,false,false,false,false,false,true,true,false,false};

        for(int i=0;i<str.length;i++){
            boolean result = ValidNumber.isNumber(str[i]);
            System.out.println(str[i]+":"+ result);
            assert result == resultArr[i];
        }
    }
}