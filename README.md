# leetcode

## [217. Contains Duplicate ](https://leetcode.com/problems/contains-duplicate/)(2019-07-04)
### 题目：
    Given an array of integers, find if the array contains any duplicates.
    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
### 测试案例：
#### Example 1:
    Input: [1,2,3,1]
    Output: true
#### Example 2:
    Input: [1,2,3,4]
    Output: false
#### Example 3:
    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true

### 解题思路：
    使用HashMap存储数组的元素，遍历数组的所有元素，判断HashMap中是否存在该元素，如果存在该元素，则直接返回true; 遍历完成后，则返回false
    
## [219.Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)
### 题目：
    Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
### 测试案例：
#### Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true
#### Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true
#### Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false  
     
### 解题思路：
    使用HashMap存储数组中元素第一次出现的位置，遍历整个数组元素，
    如果HashMap中不存在该元素，则将该元素以及该元素所在的位置加入HashMap中
    如果HashMao中存在该元素，则取出该元素第一次出现的位置，判断当前位置与第一次出现的的位置之间的差值是否小于K值，如果小于，则返回true
    
    
## [771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)（2019-07-03）
### 题目：
        You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  
        Each character in S is a type of stone you have.  
        You want to know how many of the stones you have are also jewels.
        The letters in J are guaranteed distinct, and all characters in J and S are letters. 
        Letters are case sensitive, so "a" is considered a different type of stone from "A".

### 解题思路：
       将J（珠宝）中的所有字符都存放到一个Set集合中，遍历S(拥有)，如果S中的字符再Set机和中存在，则计数器加1