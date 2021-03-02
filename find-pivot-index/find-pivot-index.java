//iterate over array once to calculate overallSum
//initialize leftSum=0, rightSum=overallSum, starting i=0, rightSum-=nums[i]
//check if leftSum == rightSum

//TC - O(n)
//Sc - O(1)
class Solution {
    public int pivotIndex(int[] nums) {
        //base case
        if(nums==null || nums.length==0)
            return -1;
        
        //initialize leftSum, rightSum, overallSum
        int leftSum=0, rightSum=0, overallSum=0;
        
        //iterate over all elements to calculate overallSum
        for(int i=0; i<nums.length; i++){
            overallSum += nums[i];
        }
        
        //iterate again, rightSum=overallSum
        //rightSum-=nums[i], check if leftSum==rightSum, if yes return i else leftSum += nums[i]  
        rightSum=overallSum;
        for(int i=0; i<nums.length; i++){
            rightSum -= nums[i];
            
            if(leftSum==rightSum)
                return i;
            
            leftSum += nums[i];
        }
        
        //default return -1
        return -1;
    }
}