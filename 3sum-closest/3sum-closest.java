/*
TC - O(n^2)
SC - O(1)

Ex: [-3,-2,-5,3,-4]
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //base case
        if(nums==null || nums.length<3)
            return -1;
        
        //init closestSum
        int closestSum = nums[0]+nums[1]+nums[nums.length-1];
        
        //sort nums
        Arrays.sort(nums);
        
        //iterate over nums, init low and high
            //move pointers according to curSum
        //[-5,-4,-3,-2,3]
        int low = 1, high = nums.length-1, curSum = 0;
        for(int i=0; i<nums.length; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            
            low = i+1;
            high = nums.length-1;
            
            while(low < high){
                curSum = nums[i] + nums[low] + nums[high];
                
                if(curSum==target)
                    return curSum;
                
                if(curSum<target){
                    low++;
                    
                    while(low<high && nums[low]==nums[low-1])
                        low++;
                }
                else{
                    high--;
                    
                    while(low<high && nums[high]==nums[high+1])
                        high--;
                } 
                
                if(Math.abs(curSum-target) < Math.abs(closestSum-target))
                    closestSum = curSum;
            }
        }
        
        //return closestSum
        return closestSum;
    }
}