package com.fulin.HashTable;

import java.util.*;

/**
 * Created by fulin on 17-1-8.
 */
public class FourSum {
    public static void main(String[] args){

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer , List<Integer[]>> map = new HashMap<Integer , List<Integer[]>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return result;
        }
        List<Integer[]> tempList = null;
        Arrays.sort(nums);
        for(int i=0 ;i< nums.length -1; i++){
            for(int j= i+1 ;j< nums.length ; j++){
                int sum = nums[i] + nums[j];
                Integer[] tuple = {nums[i],i,nums[j],j};
                if(!map.containsKey(sum)){
                    tempList = new ArrayList<Integer[]>();
                    tempList.add(tuple);
                    map.put(sum, tempList);
                }else{
                    map.get(sum).add(tuple);
                }
            }
        }

        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        for(Integer key : keys){
            if(map.containsKey(key)){
                if(map.containsKey(target - key)){
                    List<Integer[]> firstPairList = map.get(key);
                    List<Integer[]> secondPairList = map.get(target - key);

                    for(int i=0;i<firstPairList.size();i++){
                        for (int j=0;j<secondPairList.size();j++){
                            Integer[] firstPair = firstPairList.get(i);
                            Integer[] secondPair = secondPairList.get(j);

                            if(firstPair[1] != secondPair[1] && firstPair[1] != secondPair[3]
                                    && firstPair[3] != secondPair[1] && firstPair[3] != secondPair[3]){
                                List<Integer> list = Arrays.asList(firstPair[0],firstPair[2],secondPair[0],secondPair[2]);
                                Collections.sort(list);

                                if(!result.contains(list)){
                                    result.add(list);
                                }
                            }


                        }
                    }
                }

                map.remove(key);
                map.remove(target - key);
            }

        }

        return result;
    }
}
