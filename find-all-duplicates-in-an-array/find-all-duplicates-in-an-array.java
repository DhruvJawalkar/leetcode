class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //base case
        if(nums==null || nums.length==0)
            return new ArrayList<Integer>();
        
        
        ArrayList<Integer> output = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1;
            
            if(nums[idx]<0)
                output.add(Math.abs(nums[i]));
            
            nums[idx] = -nums[idx];
        }
        
        return output;
    }
}