package com.fulin.Array;

import java.util.*;

public class RandomizedSet {
	
	public static void main(String[] args){
		RandomizedSet obj = new RandomizedSet();
		int val = 2;
		boolean param_1 = obj.insert(val);
		boolean param_2 = obj.remove(val);
		System.out.println(param_1+" : "+ param_2);
		obj.insert(val);
		obj.insert(3);
		obj.insert(13);
		obj.insert(23);
		obj.insert(33);
		obj.insert(43);
		
		int param_3 = obj.getRandom();
		System.out.println(param_3);
	}
	
	public Map<Integer , Integer> map ;
    public List<Integer> list ;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
       map  = new HashMap<Integer , Integer>();
       list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val , list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        
        int index = map.get(val);
        map.remove(val);
        // if val is the last element
        if(index == list.size() -1){
        	list.remove(index);
        }else{
        	int lastVal = list.get(list.size() - 1);
        	list.set(index, lastVal);
        	list.remove(list.size() - 1);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random =  new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

}
