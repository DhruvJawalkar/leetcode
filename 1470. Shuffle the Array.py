class Solution:
def shuffle(self, nums: List[int], n: int) -> List[int]:
    res = []
    
    for i in range(n, len(nums)):
        res.append(nums[i-n])
        res.append(nums[i])
    
    return res
    
