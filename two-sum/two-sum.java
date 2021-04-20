/*
Input: nums = [2,7,11,15], target = 9
numLookupMap = {
    2: 0
}

TC - O(n)
SC - O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numLookupMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(numLookupMap.containsKey(target-nums[i]))
                return new int[]{numLookupMap.get(target-nums[i]), i};
            
            else
                numLookupMap.put(nums[i], i);
        }
        
        return new int[]{-1,-1};
    }
}