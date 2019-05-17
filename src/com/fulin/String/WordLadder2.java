package com.fulin.String;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * 参考链接：https://www.cnblogs.com/splash/p/4102786.html
 *
 *
 */
public class WordLadder2 {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<>();
        // 如果wordList 为空，则返回0
        if (wordList == null || wordList.size() == 0 || beginWord.length() != endWord.length()) {
            return resultList;
        }
        // 将List 更换为set 加快执行速度
        Set<String> wordSet = new HashSet<>(wordList);

        // 如果endWord不在wordList 中 ，直接返回0
        if (!wordSet.contains(endWord)) {
            return resultList;
        }

        LinkedList<String> wordQueue = new LinkedList<>();
        HashMap<String , List<String>>  preNodeMap = new HashMap<>();       // 用于存放节点的所有前序节点
        HashMap<String,Integer> pathNumMap =  new HashMap<>();              // 用于记录该节点在路径上的长度
        HashSet<String> hs = new HashSet<>();                               // 用于记录所遍历的节点

        //初始化 beginWord 和endWord 的前驱节点
        preNodeMap.put(beginWord,new ArrayList<>());
        preNodeMap.put(endWord,new ArrayList<>());
        wordQueue.add(beginWord);
        pathNumMap.put(beginWord,1);


        while (!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            hs.add(word);
            List<String> neighborList = getNei(word,wordSet);
            // 获取当前点在路径上的 长度
            int path = pathNumMap.get(word);
            for (String temp : neighborList) {
                // 判断相邻点是否为endWord
                if (endWord.equals(temp)) {
                    // 判断之前的路径这种是否出现过endWord
                    if(!pathNumMap.containsKey(temp)){
                        //如果没出现过endWord，则将该节点加到之前的路径中，并将endWord的前驱节点增加当前节点
                        pathNumMap.put(endWord,path + 1);
                        preNodeMap.get(endWord).add(word);
                    }else if(pathNumMap.get(temp) == path+1 ){
                        // 如果之前的路径中出现过该节点，则需要判断endWord 的路径长度是否为当前节点的路径长度+1
                        preNodeMap.get(endWord).add(word);
                    }
                }else if(wordSet.contains(temp) && !hs.contains(temp)){
                    //如果当前节点不为endWord
                    //判断相邻节点是否在之前的路径中出现过
                    if(!pathNumMap.containsKey(temp)){
                        //如果没出现过，则将相邻节点 添加到queue中 更新之前路径变量，并把相邻节点添加到前驱节点Map中
                        wordQueue.add(temp);
                        pathNumMap.put(temp,path + 1);
                        List<String> tempList = new ArrayList<>();
                        tempList.add(word);
                        preNodeMap.put(temp,tempList);
                    }else if(pathNumMap.get(temp) == path + 1){
                        //如果 之前的路径中出现过相邻节点，则需要判断该节点在之前路径长度是否等于当前节点的路径长度+1
                        preNodeMap.get(temp).add(word);
                    }
                }
            }
        }
        // 整理最后输出结果
        List<String> pathList = new ArrayList<>();
        pathList.add(endWord);
        collectResultList(beginWord,endWord,resultList,preNodeMap,pathList);

        return resultList;
    }

    /**
     * 将 中间结果整理成最后所需要的结果
     * @param beginWord：开始单词
     *                  例如：hit
     * @param endWord:结束单词
     *               例如：cog
     * @param resultList：最终返回结果
     *                  [hit","hot","dot","dog","cog"]
     *                  ["hit","hot","lot","log","cog"]
     * @param preNodeMaps:中间计算结果
     *                  preNodeMap.put("hit",new ArrayList<>());
     *                  preNodeMap.put("hot",new ArrayList<>(Arrays.asList("hit")));
     *                  preNodeMap.put("dot",new ArrayList<>(Arrays.asList("hot")));
     *                  preNodeMap.put("lot",new ArrayList<>(Arrays.asList("hot")));
     *                  preNodeMap.put("dog",new ArrayList<>(Arrays.asList("dot")));
     *                  preNodeMap.put("log",new ArrayList<>(Arrays.asList("lot")));
     *                  preNodeMap.put("cog",new ArrayList<>(Arrays.asList("dog","log")));
     * @param pathList:
     *
     */
    public static void collectResultList(String beginWord,String endWord,List<List<String>> resultList , HashMap<String , List<String>> preNodeMaps,List<String> pathList){
        List<String> endList = preNodeMaps.get(endWord);
        // 把结束
        for(String endPreWord : endList){
            pathList.add(0,endPreWord);
            if(endPreWord.equals(beginWord)){
                List<String> pathCopy = new ArrayList<>(pathList);
                resultList.add(pathCopy);
            }else {
                collectResultList(beginWord,endPreWord,resultList,preNodeMaps,pathList);
            }
            pathList.remove(0);
        }



    }

    /**
     * 获取指定字符串的 相差一个字符的邻居字符串
     * @param str
     * @param set
     * @return
     */
    private static List<String> getNei(String str, Set<String> set) {
        List<String> ret = new ArrayList<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char t = ch[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == t) continue;
                ch[i] = c;
                String tmp = new String(ch);
                if (set.contains(tmp)) ret.add(tmp);
            }
            ch[i] = t;
        }
        return ret;
    }
}
