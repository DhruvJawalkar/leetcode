class Solution:
def runningSum(self, nums: List[int]) -> List[int]:
    cur_sum = 0
    res = []
    
    for n in nums:
        cur_sum += n
        res.append(cur_sum)
    
    return res
