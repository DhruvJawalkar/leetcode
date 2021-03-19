//Ex - nums = [-1,2,1,-4], target = 1
//TC - O(n^2)
//SC - O(log n)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //init closestSum
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[n-1];
        
        //sort nums
        Arrays.sort(nums);
        
        int start, end, curSum;
        
        //iterate over nums, move i from 0 till n-3
        for(int i=0; i<n-2; i++){
            start = i+1;
            end = n-1;
            
            while(start<end){ 
                curSum = nums[i] + nums[start] + nums[end];
                
                if(Math.abs(curSum-target)<Math.abs(closestSum-target))
                    closestSum = curSum;        
        
                if(curSum==target)
                    return curSum;
                
                else if(curSum<target)
                    start++;
                else
                    end--;                
            }
        }
   
        //return closestSum
        return closestSum;
    }
}