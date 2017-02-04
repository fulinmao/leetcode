package com.fulin.Array;

import java.util.*;

/**
 * Created by fulin on 17-1-8.
 */
public class ThreeSum {
    public static void main(String[] args){

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer,List<Integer[]>> map = new HashMap<Integer,List<Integer[]>>();
        if(nums == null || nums.length <3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length - 1;i++){
            for (int j=i+1;j<nums.length;j++){
                int sum = nums[i] + nums[j];
                Integer[] tuple = {nums[i] , i , nums[j] , j};
                if(map.containsKey(sum)){
                    map.get(sum).add(tuple);
                }else{
                    List<Integer[]> tempList = new ArrayList<Integer[]>();
                    tempList.add(tuple);
                    map.put(sum,tempList);
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(0 - num)){
                List<Integer[]> pairList = map.get(0 - num);
                for(Integer[] pair :pairList){

                    if(pair[1] != i && pair[3] != i){
                        List<Integer> list = Arrays.asList(num , pair[0],pair[2]);
                        Collections.sort(list);

                        if(!result.contains(list)){
                            result.add(list);
                        }

                    }
                }
                map.remove(0-num);
            }
        }

        return result;
    }
}
