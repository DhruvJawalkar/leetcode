/*
TC - O((n-l)*l)
SC - O(1)

Ex: Input: haystack = "hello", needle = "ll"
n = 5
l = 2

"hello"
   i
     k
   
  "ll"
     j
     
output - 2
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0)
            return 0;
        
        int n = haystack.length();
        int l = needle.length();
        
        for(int i=0; i<=n-l; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int k = i;
                int j = 0;
                
                while(j<l && haystack.charAt(k)==needle.charAt(j)){
                    k++;
                    j++;
                }
                
                if(j==l)
                    return i;
            }
        }
        
        return -1;
    }
}