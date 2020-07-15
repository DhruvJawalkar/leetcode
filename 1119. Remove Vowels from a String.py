class Solution:
def removeVowels(self, S: str) -> str:
    res = ''
    
    for c in S:
        if(c not in ['a', 'e', 'i', 'o', 'u']):
            res = res + c
    
    return res
    
