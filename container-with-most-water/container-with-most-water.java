/*
TC - O(n)
SC - O(1)
                 0 1 2 3 4 5 6 7 8
Input: height = [1,8,6,2,5,4,8,3,7]
                     i
                     j
maxWater = 49
*/
class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int maxWater = (j-i) * Math.min(height[i], height[j]);
        
        while(i<j){
            if(height[i]<height[j])
                i++;   
            else
                j--;
            
            maxWater = Math.max(maxWater, (j-i) * Math.min(height[i], height[j]));
        }
        
        return maxWater;
    }
}