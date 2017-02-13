package com.fulin.Array;

import com.fulin.Utils.Interval;

import java.util.*;

/**
 * Created by fulin on 16-12-11.
 */
public class MergeIntervals {
    public static void main(String[] args){


    }

    public class MyComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() ==0){
            return null;
        }

        if(intervals.size() == 1){
            return intervals;
        }

        Collections.sort(intervals,new MyComparator());

        List<Interval> list = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;


        for(int i=0;i<intervals.size();i++){
            Interval temp = intervals.get(i);
            if( temp.start > end){
                list.add(new Interval(start,end));
                start = temp.start;
                end = temp.end;

            }else{
                end = Math.max(temp.end , end);
            }

        }
        list.add(new Interval(start,end));
        return list;

    }

    private Interval mergeTwoInterval(Interval intervals1 , Interval intervals2){
        Interval result = null;
        int start = 0;
        int end = 0;
        boolean isMerge = false;
        if(intervals1.start >= intervals2.start){
            Interval temp = intervals1;
            intervals1 = intervals2;
            intervals2 = temp;
        }
        if(intervals1.end >= intervals2.start && intervals1.end <= intervals2.end){
            start = intervals1.start;
            end = intervals2.end;
            isMerge = true;
        }

        if(intervals1.end >= intervals2.start && intervals1.end >= intervals2.end){
            start = intervals1.start;
            end = intervals1.end;
            isMerge = true;
        }

        if(isMerge){
            result = new Interval(start,end);
        }
        return result;
    }
}
