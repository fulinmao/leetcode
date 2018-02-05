package com.fulin.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulin on 18-2-5.
 */
public class MinStack {

    public List<Integer> list = null;
    public int topIndex;

    public MinStack() {
        list = new ArrayList<Integer>();
        topIndex = -1;
    }


    public void push(int x) {
        list.add(x);
        topIndex ++;
    }

    public void pop() {
        if(topIndex < 0){
            return;
        }

        list.remove(topIndex --);
    }

    public int top() {
        if(topIndex < 0){
            return -1;
        }
        return list.get(topIndex);
    }

    public int getMin() {
        if(list == null || list.size() == 0){
            return -1;
        }
        int min = list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        return min;
    }
}
