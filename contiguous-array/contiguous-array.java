class Solution {
    public int findMaxLength(int[] nums) {
        //base case
        if(nums==null || nums.length==0)
            return 0;
        
        //initialize max, curSum, hashmap
        int max=0, curSum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        //calculate running sum, +1 for 1, -1 for 0, if havent seen curSum before, put else continue
        //if seen curSum before, in hashmap, calculate i-map.get(curSum)
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1)
                curSum += 1;
            else
                curSum -= 1;
            
            if(!map.containsKey(curSum))
                map.put(curSum, i);
            else
                max = Math.max(max, i-map.get(curSum));
        }
​
        return max;        
    }
}
