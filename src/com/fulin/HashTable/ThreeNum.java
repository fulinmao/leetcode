package com.fulin.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

/**
 * Created by fulin on 17-1-15.
 */
public class ThreeNum {

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i=0;i <= nums.length - 3 ;i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            jumppAndInput(nums,result,i,i+1,nums.length - 1);
        }

        return result;
    }

    private static void jumppAndInput(int[] nums ,List<List<Integer>> result, int i , int p , int q){
        while(p < q){
            if(nums[p] + nums[q] < 0 - nums[i]){
                p++;
            }else if(nums[p] + nums[q] > 0 - nums[i]){
                q -- ;
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                list.add(nums[p]);
                list.add(nums[q]);
                result.add(list);
                p++;
                q--;
                //过滤掉相同的元素
                while(p < q && nums[p] == nums[p-1]){
                    p++;
                }

                while(p < q && nums[q] == nums[q+1]){
                    q --;
                }
            }

        }
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
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
