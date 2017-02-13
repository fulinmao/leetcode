package com.fulin.DP;

import java.util.List;

/**
 * Created by fulin on 17-2-8.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int high = triangle.size();

        for(int i=high - 2;i >= 0;i--){
            List<Integer> list = triangle.get(i);
            List<Integer> listNext = triangle.get(i + 1);
            int width = list.size();
            if(width <= i){
                return 0;
            }
            for(int j=0;j<=i;j++){
                list.set(j,Math.min(listNext.get(j) ,listNext.get(j+1)) + list.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
