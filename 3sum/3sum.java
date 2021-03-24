//TC - O(n log n)
//SC - O(1)
//Ex: [-1,0,1,2,-1,-4]

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //base case
        if(nums==null || nums.length<3)
            return new ArrayList<List<Integer>>();
        
        //init output
        List<List<Integer>> output = new ArrayList<>();
        
        //sort input
        //[-4,-1,-1,-1,0,1,2,2]
        Arrays.sort(nums);
        
        int low = 1, high = nums.length-1, sum = 0;
        //iterate over nums
            //skip duplicates
            //init low and high and move then according to cur sum
        for(int i=0; i<=nums.length-3; i++){
            if(nums[i]>0)
                break;
            
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            
            low = i+1;
            high = nums.length-1;
            
            while(low<high){  
                sum = nums[i] + nums[low] + nums[high];
                
                if(sum==0){
                    output.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[low], nums[high])));
                    low++;
                    high--;
                    
                    while(low<high && nums[low]==nums[low-1])
                        low++;
                    while(low<high && nums[high]==nums[high+1])
                        high--;
                }
                else if(sum<0)
                    low++;
                else
                    high--;
            }
        }
        
        //return output
        return output;
        
    }
}