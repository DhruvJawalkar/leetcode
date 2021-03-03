class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
            //base cases
        if(s==null || s.length()==0 || s.length() == 1)
          return -1;
        
        //initialize hashmap, longestSubStringLen = -1
        HashMap<Character, Integer> map = new HashMap<>();
        int longestSubStringLen = -1;
        
        //1st pass, update last index of each char
        for(int i=0; i<s.length();i++){
          char ch = s.charAt(i);
          
          //if(!map.containsKey(ch)){
          map.put(ch, i);
          //}
        }
        
        //2nd pass if char in hashmap check if j-i-1 is greater than cur max 
        for(int i=0; i<s.length();i++){
          char ch = s.charAt(i);
          
          if(map.containsKey(ch))
              longestSubStringLen = Math.max(longestSubStringLen, map.get(ch)-i-1);
          
        }
        
        //return longestSubStringLen
        return longestSubStringLen;    
    }
}