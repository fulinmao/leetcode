package com.fulin.String;

import java.util.*;

public class WordLadder {

//        public static List<String> pathList = new ArrayList<String>();
//
//        public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//            int result = 0;
//            // 如果wordList 为空，则返回0
//            if (wordList == null || wordList.size() == 0) {
//                return result;
//            }
//            // 如果endWord不在wordList 中 ，直接返回0
//            if (!wordList.contains(endWord)) {
//                return result;
//            }
//            pathList = new ArrayList<>();
//            ladderLengthRecursion(beginWord,endWord,wordList);
//            for(int i=0;i<pathList.size();i++){
//                System.out.print(pathList.get(i)+"\t");
//            }
//            return pathList.size();
//        }
//
//        public static void ladderLengthRecursion(String beginWord, String endWord, List<String> wordList ) {
//
//            if (wordList == null || wordList.size() == 0) {
//                pathList = new ArrayList<String>();
//                return ;
//            }
//
//            if (!wordList.contains(endWord)) {
//                pathList = new ArrayList<String>();
//                return ;
//            }
//            if(beginWord.length() == 1){
//                pathList.add(endWord);
//                pathList.add(beginWord);
//                return ;
//            }
//
//
//            List<String> resultList = new ArrayList<String>();
//            // 查找与当前单词的长度为1 的所有单词
//            for(int i=0;i<wordList.size();i++){
//                if(wordDistance(endWord,wordList.get(i)) == 1){
//                    resultList.add(wordList.get(i));
//                }
//            }
//
//            // 如果没有找到与当前单词长度为1的单词，则直接返回0
//            if(resultList == null || resultList.size() == 0){
//                pathList = new ArrayList<>();
//                return ;
//            }
//
//            // 将endword从 wordList 中移除
//            List<String> tempList = new ArrayList<>(wordList);
//            tempList.remove(tempList.indexOf(endWord));
//            pathList.add(endWord);
//            // 如果找到与当前元素距离为1的单词是否与beginWord 的距离为1，如果为1的话，则直接返回结果，结束查找
//            for(int i=0;i<resultList.size();i++){
//                if(wordDistance(beginWord,resultList.get(i)) == 1){
//                    pathList.add(resultList.get(i));
//                    pathList.add(beginWord);
//                    return ;
//                }else if(wordDistance(beginWord,resultList.get(i)) == 0){
//                    pathList.add(beginWord);
//                    return;
//                }
//            }
//
//            for(int i = 0;i<resultList.size();i++){
//                if(! pathList.contains(resultList.get(i)) ){
//                    ladderLengthRecursion(beginWord,resultList.get(i),tempList);
//                    if(pathList.size()!= 0){
//                        break;
//                    }
//                }
//            }
//            return ;
//        }
//



    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        // 如果wordList 为空，则返回0
        if (wordList == null || wordList.size() == 0 || beginWord.length() != endWord.length()) {
            return result;
        }
        // 如果endWord不在wordList 中 ，直接返回0
        if (!wordList.contains(endWord)) {
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
            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < wordList.size(); i++) {
                String temp = wordList.get(i);
                int distance = wordDistance(word, temp);
                if (distance == 1) {
                    resultList.add(temp);
                }
            }

            for (int i = 0; i < resultList.size(); i++) {
                String temp = resultList.get(i);
                if (endWord.equals(temp)) {
                    result++;
                    return result;
                }
                if (wordList.contains(temp)) {
                    wordQueue.add(temp);
                    wordList.remove(wordList.indexOf(temp));
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

    private List<String> getNei(String str, Set<String> set) {
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
