package com.fulin.Array;

import java.util.*;

public class RandomizedCollection {
	public Map<Integer , Set<Integer>> map;
	public List<Integer> list;
	
	public RandomizedCollection() {
		map = new HashMap<Integer , Set<Integer>>();
		list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	Set<Integer> valSet = new HashSet<Integer>();
    	boolean result = true;
        if(map.containsKey(val)){
        	valSet = map.get(val);
        	result = false;
        }
        valSet.add(list.size());
        map.put(val, valSet);
        list.add(val);
        return result;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if( !map.containsKey(val)){
    		return false;
    	}
    	Set<Integer> valSet = map.get(val);
    	int removeIndex = valSet.iterator().next();
    	valSet.remove(removeIndex);
    	if(valSet.size() ==0){
    		map.remove(val);
    	}else{
    		map.put(val, valSet);
    	}
    	
    	if(removeIndex == list.size() - 1){
    		//the last element
    		list.remove(removeIndex);
    	}else{
    		int lastVal = list.get(list.size() - 1);
    		list.set(removeIndex, lastVal);
    		list.remove(list.size() - 1);
    		valSet = map.get(lastVal);
    		valSet.remove(list.size());
    		valSet.add(removeIndex);
    		map.put(lastVal, valSet);
    	}
    	
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
