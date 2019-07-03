# leetcode

# [771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)（2019-07-03）
    题目：
        You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
        The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

    解题思路：
       将J（珠宝）中的所有字符都存放到一个Set集合中，遍历S(拥有)，如果S中的字符再Set机和中存在，则计数器加1