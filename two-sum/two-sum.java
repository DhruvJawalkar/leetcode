/*
TC - O(n)
SC - O(n)

Ex: nums = [2,7,11,15], target = 9
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int complement;
        for(int i=0; i<nums.length; i++){
            complement = target - nums[i];
            
            if(map.containsKey(complement))
                return new int[]{i, map.get(complement)};
            
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No two sum solution");
    }
}