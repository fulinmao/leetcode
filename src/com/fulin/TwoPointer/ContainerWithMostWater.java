public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        
        if (height.length < 2) return 0;  
        int max = 0;  
        int left = 0;  
        int right = height.length - 1;  
        while (left < right) {  
            int v = (right - left) * Math.min(height[left], height[right]);  
            if (v > max) max = v;  
            if (height[left] < height[right]) {
                left++;  
            }else{
                right--;  
            }   
        }  
        return max; 
    }
}
