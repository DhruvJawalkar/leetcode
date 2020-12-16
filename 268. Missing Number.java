//TC : O(n)
//SC: O(1)
//Approach: Use sum of all digits property, n*(n+1)/2 for sum of all digits, subtract from running sum
class Solution {
    public int missingNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        
        return (n*(n+1)/2) - sum;
    }
}