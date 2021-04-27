//nums = [2,7,11,15], target = 9
//

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numLookupMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(numLookupMap.containsKey(compliment))
                return new int[]{numLookupMap.get(compliment), i};
            else
                numLookupMap.put(nums[i], i);
        }
        
        return new int[]{-1,-1};
    }
}