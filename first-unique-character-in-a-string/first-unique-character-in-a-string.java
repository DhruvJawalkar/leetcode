/*
TC - O(n)
SC - O(1)

Ex: "leetcode"
*/

class Solution {
    public int firstUniqChar(String s) {
        if(s.length()==1)
            return 0;
        
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0)+1);
        }
        
        for(int i=0; i<s.length(); i++){            
            if(charCountMap.get(s.charAt(i))==1)
                return i;
        }
        
        return -1;
    }
}