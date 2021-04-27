/*
Ex: "abcabcbb"
            i
            j
maxLength = 3
map = {
    a : 3
    b : 1
    c : 2
}

Exp - 3
output - 3

TC - O(n), n is length of string
SC - O(n) 
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxLength = 1;
        
        for(int j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            
            if(!map.containsKey(ch) || map.get(ch)<i){
                map.put(ch, j);
                maxLength = Math.max(maxLength, j-i+1);
            }
            else{
                i = map.get(ch)+1;
                map.put(ch, j);
            }
        }
        
        return maxLength;
    }
}