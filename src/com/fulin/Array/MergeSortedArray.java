package com.fulin.Array;

/**
 * Created by fulin on 16-12-10.
 */
public class MergeSortedArray {

    public static void main(String[] args){
        int[] nums1 = new int[2];
        nums1[0] = 0;
        int[] nums2 = {1};

        merge(nums1 , 1, nums2 , 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length ==0){
            return ;
        }
        int index =  m + n - 1;
        int max ;
        while(m > 0 && n > 0 && index >=0){
            if(nums1[m - 1] > nums2[n - 1] ){
                max =  nums1[m-1];
                m--;
            }else{
                max = nums2[n-1] ;
                n -- ;
            }
            nums1[index --] = max;
        }

        if(n != 0){
            while(n > 0){
                max =  nums2[n -1];
                nums1[index --] = max;
                n--;
            }
        }
        return ;

    }
}
