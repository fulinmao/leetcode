package com.fulin.String;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadder2Test {

    @Test
    public void findLadders() {
        String endWord = "cog";
        String beginWord = "hit";
        List<String> dictList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

        List<List<String>> resultList = WordLadder2.findLadders(beginWord,endWord,dictList);
        System.out.println("计算结果：");
        for (List<String> temp : resultList){
            for (String t : temp){
                System.out.print(t + "\t");
            }
            System.out.println();
        }

        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList("hit","hot","dot","dog","cog")));
        result.add(new ArrayList<>(Arrays.asList("hit","hot","lot","log","cog")));

        assert  result.containsAll(resultList)  && resultList.containsAll(result);
    }

    @Test
    public void collectResultList() {
        String endWord = "cog";
        String beginWord = "hit";
        List<String> pathList = new ArrayList<>();
        pathList.add(endWord);
        List<List<String>> resultList = new ArrayList<>();
        HashMap<String , List<String>> preNodeMap = new HashMap<>();
        preNodeMap.put("hit",new ArrayList<>());
        preNodeMap.put("hot",new ArrayList<>(Arrays.asList("hit")));
        preNodeMap.put("dot",new ArrayList<>(Arrays.asList("hot")));
        preNodeMap.put("lot",new ArrayList<>(Arrays.asList("hot")));
        preNodeMap.put("dog",new ArrayList<>(Arrays.asList("dot")));
        preNodeMap.put("log",new ArrayList<>(Arrays.asList("lot")));
        preNodeMap.put("cog",new ArrayList<>(Arrays.asList("dog","log")));

        WordLadder2.collectResultList(beginWord,endWord,resultList,preNodeMap,pathList);
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList("hit","hot","dot","dog","cog")));
        result.add(new ArrayList<>(Arrays.asList("hit","hot","lot","log","cog")));

        assert result.containsAll(resultList);
    }
}