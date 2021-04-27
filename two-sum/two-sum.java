/*
nums = [2,7,11,15], target = 9
map = {
    2 : 0
}
output - [0, 1]

TC - O(n)
SC - O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }
            else{
                map.put(nums[i], i);
            }
        }
        
        return new int[]{-1, -1};
    }
}