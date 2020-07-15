class Solution:
def numIdenticalPairs(self, nums: List[int]) -> int:
    num_pairs = 0
    
    for i in range(len(nums)-1):
        for j in range(i+1, len(nums)):
            if(nums[i]==nums[j]):
                num_pairs += 1
    
    return num_pairs
