package com.fulin.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulin on 18-2-3.
 */
public class PascalTriangleII {

    public static void main(String args[]){
        int rowIndex = 13;
        List<Integer> result = getRow(rowIndex);
        System.out.println(result);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex  < 0){
            return result;
        }

        result.add(1);
        for(int i=1;i<= rowIndex;i++){

            for(int j= result.size() -2 ; j >= 0 ; j--){
                result.set(j+1,result.get(j) + result.get(j+1));
            }
            result.add(1);
        }
        return result;
    }


}
