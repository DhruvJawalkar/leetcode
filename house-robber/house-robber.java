/*
Input: nums = [2,1,1,2]
            p1 = 1
            p2 = 3
curBest = 3
n = 4


output = 4

TC - O(n)
SC - O(1)
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);
        
        int n = nums.length;
        int p1 = nums[0];
        int p2 = Math.max(p1, nums[1]);
        int curBest = Math.max(p1, p2);
        
        for(int i=2; i<n; i++){
            curBest = Math.max(nums[i]+p1, p2);
            p1 = p2;
            p2 = curBest;
        }
        
        return curBest;
    }
}