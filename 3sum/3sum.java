/*
Ex: nums = [-1,0,1,2,-1,-4]
[-1,0,1,2,-1,-4]

[-4,-1,-1,0,1,2]

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3)
            return new ArrayList<List<Integer>>();
        
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0; i<n-2; i++){
            if(nums[i]>0)
                break;
            
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            int low = i+1;
            int high = n-1;
            int sum;
            
            while(low<high){
                sum = nums[i] + nums[low] + nums[high];
                
                if(sum==0){
                    output.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                }
                else if(sum<0)
                    low++;
                else 
                    high--;
                
                while(low<high && low>i+1 && nums[low]==nums[low-1]){
                    low++;
                }
                
                while(low<high && high<n-1 && nums[high]==nums[high+1]){
                    high--;
                }
            }
        }
        
        return output;
    }
}