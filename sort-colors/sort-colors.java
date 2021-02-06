class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
        
        int i=0, j=nums.length-1;
        int k=0;
        while(k<=j){
            if(nums[k]==2){
                swap(nums, k, j);
                j--;
            }
            else if(nums[k]==0){
                swap(nums, k, i);
                k++;
                i++;
            }
            else{
                k++;    
            }   
        }
    }
    
    private void swap(int[] nums, int k, int j){
        int temp;
        temp = nums[k];
        nums[k] = nums[j];
        nums[j] = temp;
    }
}