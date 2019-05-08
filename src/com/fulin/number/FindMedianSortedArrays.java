package com.fulin.number;

public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1 = 0;
        int start2 = 0;
        double result = 0.0;
        int totalNums = nums1.length + nums2.length;
        int resultIndex1 = 0;
        int resultIndex2 = 0;

        if(totalNums % 2 ==0){
            resultIndex2 = totalNums / 2;
            resultIndex1 = resultIndex2 - 1;
        }else{
            resultIndex1 = totalNums / 2;
            resultIndex2 = resultIndex1;
        }
        if(nums1.length ==0){
            result = (nums2[resultIndex1] + nums2[resultIndex2])/2.0;
            return result;
        }

        if(nums2.length ==0){
            result = (nums1[resultIndex1] + nums1[resultIndex2])/2.0;
            return result;
        }

        while(start1 < nums1.length ||  start2 < nums2.length){
            if(start1 + start2 > resultIndex2){
                break;
            }
            if(start1 >= nums1.length){
                if(start1   + start2 == resultIndex1){
                    result += nums2[start2];
                }else if(start1  + start2 == resultIndex2){
                    result += nums2[start2];
                    break;
                }
                start2 ++;
            }else if(start2 >= nums2.length){
                if(start1   + start2  == resultIndex1){
                    result += nums1[start1];
                }else if(start1  + start2  == resultIndex2){
                    result += nums1[start1];
                    break;
                }
                start1 ++;
            }else {
                if (nums1[start1] <= nums2[start2]) {
                    if (start1 + start2 == resultIndex1) {
                        result += nums1[start1];
                    } else if (start1 + start2 == resultIndex2) {
                        result += nums1[start1];
                        break;
                    }
                    start1++;
                } else {
                    if (start1 + start2 == resultIndex1) {
                        result += nums2[start2];
                    } else if (start1 + start2 == resultIndex2) {
                        result += nums2[start2];
                        break;
                    }
                    start2++;
                }
            }
        }

        if(resultIndex1 != resultIndex2){
            result /=  2.0;
        }

        return result;
    }

    /***
     *  如果总元素个数N 为偶数个，则中位数为 两个数组排序后第(N/2 -1 )个元素与第（N/2）个元素的平均数
     *  如果总元素个数N 为奇数个，则中位数为第（N/2）个数
     *
     *  该方法只需要根据两个排序数组中指定位置的数字即可
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        double result = 0;
        if((m + n) % 2 != 0){
            result = findKthSmall(nums1,0,m-1,nums2,0,n-1,((m+n)/2 + 1));
        }else{
            result = ( findKthSmall(nums1,0,m-1,nums2,0,n-1,(m+n)/2) + findKthSmall(nums1,0,m-1,nums2,0,n-1,((m+n)/2 + 1)) ) /2.0;
        }

        return result;
    }

    /**
     *  查找2个排序数组中第K个小的元素
     * @param nums1：排序数组1
     * @param startM：nums1 开始元素索引
     * @param endM：nums1 结束元素索引
     * @param nums2：排序数组2
     * @param startN：nums2 开始元素索引
     * @param endN：nums2 结束元素索引
     * @param k ：第K个小元素
     * @return
     */
    private static int findKthSmall(int[] nums1, int startM, int endM, int[] nums2, int startN, int endN, int k){
        int m = endM - startM + 1;
        int n = endN - startN + 1;

        if(n <= 0){
            return nums1[startM + k - 1];
        }

        if(m <= 0){
            return nums2[startN + k-1];
        }

        if(m > n){
            return findKthSmall(nums2, startN, endN, nums1, startM, endM, k);
        }
        if(k == 1){
            return min(nums1[startM] , nums2[startN]);
        }

        int pa = k / 2;
        pa = min(pa , m);
        int pb = k - pa;

        if(nums1[startM + pa - 1] < nums2[startN +pb - 1]){
            return findKthSmall(nums1,startM + pa,endM,nums2,startN,endN, k -pa);
        }

        if(nums1[startM + pa - 1] > nums2[startN + pb - 1]){
            return findKthSmall(nums1,startM,endM,nums2,startN + pb,endN, k -pb);
        }

        return nums1[pa - 1];

    }

    private static int min(int a, int b){
        return a > b ? b : a;
    }
}
