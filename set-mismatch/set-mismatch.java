/*
Input - [5,4,3,1,1]
 
[-5,4,-3,-1,-1]
 0  1  2  3  4 
 
output - [1, 2]
TC - O(n)
SC - O(1)

[3,3,-1]
 0 1 2
*/
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for(int n : nums){
            int idx = Math.abs(n)-1; 
            if(nums[idx] < 0)
                result[0] = Math.abs(n);
            else
                nums[idx] = -1*nums[idx];
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                result[1] = i+1;
                break;
            }
        }
        
        return result;
    }
}