class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        if(len(nums)==1):
            return -1
        
        nums.sort()
        closest_sum = -1
        i,j = 0,len(nums)-1

        while(nums[j]>=k):
            j-=1
            
        while i<j:
            if(nums[i]+nums[j] >= k):
                j-=1
            else:
                closest_sum = max(closest_sum, nums[i]+nums[j])
                i+=1

        return closest_sum
        