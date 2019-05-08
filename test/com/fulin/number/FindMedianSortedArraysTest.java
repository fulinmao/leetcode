package com.fulin.number;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* FindMedianSortedArrays Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2019</pre> 
* @version 1.0 
*/ 
public class FindMedianSortedArraysTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findMedianSortedArrays(int[] nums1, int[] nums2) 
* 
*/ 
@Test
public void testFindMedianSortedArrays() throws Exception {
    int[] nums1 = {1,2};
    int[] nums2 = {3,4};
    double result = FindMedianSortedArrays.findMedianSortedArrays(nums1,nums2);
    System.out.println(result);
    assert result == 2.5;
}

/** 
* 
* Method: findMedianSortedArrays2(int[] nums1, int[] nums2) 
* 
*/ 
@Test
public void testFindMedianSortedArrays2() throws Exception {
    int[] nums1 = {1,2};
    int[] nums2 = {3,4};
    double result = FindMedianSortedArrays.findMedianSortedArrays2(nums1,nums2);
    System.out.println(result);
    assert result == 2.5;
}


/** 
* 
* Method: findKthSmall(int[] nums1, int startM, int endM, int[] nums2, int startN, int endN, int k) 
* 
*/ 
@Test
public void testFindKthSmall() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = FindMedianSortedArrays.getClass().getMethod("findKthSmall", int[].class, int.class, int.class, int[].class, int.class, int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: min(int a, int b) 
* 
*/ 
@Test
public void testMin() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = FindMedianSortedArrays.getClass().getMethod("min", int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
}

    @Test
    public void findMedianSortedArrays() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double result = FindMedianSortedArrays.findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
        assert result == 2.5;
    }

    @Test
    public void findMedianSortedArrays2() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double result = FindMedianSortedArrays.findMedianSortedArrays2(nums1,nums2);
        System.out.println(result);
        assert result == 2.5;
    }

}
