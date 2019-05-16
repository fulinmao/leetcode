package com.fulin.String;

import java.util.*;

public class WordLadder {


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        // 如果wordList 为空，则返回0
        if (wordList == null || wordList.size() == 0 || beginWord.length() != endWord.length()) {
            return result;
        }
        // 将List 更换为set 加快执行速度
        Set<String> wordSet = new HashSet<>(wordList);


        // 如果endWord不在wordList 中 ，直接返回0
        if (!wordSet.contains(endWord)) {
            return result;
        }
        LinkedList<String> wordQueue = new LinkedList<>();
        wordQueue.add(beginWord);
        result = 1;
        int currentNum = 1;
        int nextNum = 0;        // 当前轮次总共有多少单词是在wordList中


        while (!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            currentNum--;
            List<String> resultList = getNei(word,wordSet);
//            for (int i = 0; i < wordList.size(); i++) {
//                String temp = wordList.get(i);
//                int distance = wordDistance(word, temp);
//                if (distance == 1) {
//                    resultList.add(temp);
//                }
//            }

//            for(int i=0;i<resultList.size();i++)
            // 该方式会加快执行速度
            for (String temp : resultList) {
                if (endWord.equals(temp)) {
                    result++;
                    return result;
                }
                if (wordSet.contains(temp)) {
                    wordQueue.add(temp);
                    wordSet.remove(temp);
                    nextNum++;
                }
            }

            if (currentNum == 0) {
                currentNum = nextNum;
                nextNum = 0;
                result++;
            }

        }
        return 0;
    }

    /**
     * 比家两个单词不同的字符数
     * 假设两个单词的长度相同
     *
     * @param word1
     * @param word2
     * @return
     */
    private static int wordDistance(String word1, String word2) {
        int result = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    /**
     * 该方法耗时 10ms
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        int level = 1;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            Set<String> next = new HashSet<>();
            for (String str : begin) {
                for (String nei : getNei(str, set)) {
                    if (end.contains(nei)) return level + 1;
                    if (visited.add(nei)) next.add(nei);
                }
            }
            begin = next;
            level++;
        }
        return 0;
    }

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
