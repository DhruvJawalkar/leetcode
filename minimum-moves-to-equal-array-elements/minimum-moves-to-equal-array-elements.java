class Solution {
    public int minMoves(int[] nums) {
        //flip the problem to decrement each number to min
        //sum of differences is the no of moves
        
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int sumOfAllElements = 0;
        
        for(int i=0; i<nums.length; i++){
            sumOfAllElements += nums[i];
            min = Math.min(min, nums[i]);
        }
        
        return sumOfAllElements - min*n;
    }
}