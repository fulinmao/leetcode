# leetcode

## [53.Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
### 题目
    Given an integer array nums, find the contiguous subarray 
    (containing at least one number) which has the largest sum and return its sum.
### 测试案例
    Given an integer array nums, find the contiguous subarray 
    (containing at least one number) which has the largest sum and return its sum.
#### Example 1
    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
### 解题思路
#### 思路1
    使用蛮力查找的方式求解最大子序列和，时间复杂度O(n2)
    （1）.从第一个元素开始循环，循环所有以第一个元素开头的子序列，并计算其和的最大值
    （2）.找到每一个元素的开头的子序列和的最大值，找到最终的最大值
#### 思路2 
    使用动态规划的方式求解最大子序列和,时间复杂度为O(n)
    （1）.使用一个数组（dp）记录以数组元素结尾的最大连续子序列和
    （2）.将上述的初始值赋值为nums的元素值，使用Max(dp[i-1]+nums[i],nums[i])更新该值
    （3）.循环dp数组，找到最大值，并返回
#### 思路3
    改进动态规划的方法，去掉记录的数组dp,使用sum记录前一个元素的和,并实时计算最大值
    有一个地方需要特别注意：如果sum的值已经小于0，则需要更新sum值为当前数组的元素值

    
## [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)（2019-07-12）
### 题目
    Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction 
    (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    Note that you cannot sell a stock before you buy one.
### 测试案例
#### Example 1:
    Input: [7,1,5,3,6,4]
    Output: 5
#### Example 2:
    Input: [7,6,4,3,1]
    Output: 0    
### 解题思路
    1.只有一次买和卖的机会，且买要再卖之前完成
    2.找到数值最小的时刻买入，找到再其后最高值卖出

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