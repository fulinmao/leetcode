package com.fulin.Array;

import com.fulin.Utils.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by fulin on 16-12-25.
 */
public class InsertInterval {
    public static void main(String[] args){

    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.size() == 0){
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }

        if(newInterval == null){
            return intervals;
        }

        ListIterator<Interval> iterator = intervals.listIterator();
        while(iterator.hasNext()){
            Interval temp = iterator.next();
            if(temp.start > newInterval.end){
                iterator.previous();
                iterator.add(newInterval);
                return intervals;
            }else{
                if(temp.end < newInterval.start){
                    continue;
                }else{
                    newInterval.start = Math.min(temp.start , newInterval.start);
                    newInterval.end = Math.max(temp.end  , newInterval.end);
                    iterator.remove();
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }

}
