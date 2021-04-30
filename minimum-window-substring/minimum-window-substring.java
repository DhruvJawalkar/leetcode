/*
TC - O(T + S), T is length of string t, S is length of s
SC - O(T + S) in worst case

Input: s = "ADOBECODEBANC", t = "ABC"
charCountMapForT = {
    A : 1
    B : 1
    C : 1
}

l = 0
r = 0
formed = 3
ans = [4, 9, 12]
 0123456789101112 
"ADOBECODEBANC"
           l
              r

slidingWindow = {
    A : 1
    C : 1
    B : 0
}
*/
class Solution {
    public String minWindow(String s, String t) {
        //base cases
        if(t.length()>s.length())
            return "";
        
        //form char count map for t
        HashMap<Character, Integer> charCountMapForT = new HashMap<>();
        for(char ch : t.toCharArray()){
            charCountMapForT.put(ch, charCountMapForT.getOrDefault(ch, 0)+1);
        }
        
        //init 2 pointers l and r, formed, ans
        int l = 0, r = 0, formed = 0; 
        int[] ans = {-1, 0, 0};
        HashMap<Character, Integer> slidingWindow = new HashMap<>();
        
        //do till r reaches end of string
            //keep incrementing r till slidingWindow contains all chars in t
            //once it contains (formed==#unique chars), move l till formed, update result
        while(r < s.length()){
            while(r<s.length() && formed != charCountMapForT.size()){
                char ch = s.charAt(r);
                
                if(charCountMapForT.containsKey(ch)){
                    slidingWindow.put(ch, slidingWindow.getOrDefault(ch, 0)+1);
                    
                    if(slidingWindow.get(ch).equals(charCountMapForT.get(ch)))
                        formed++;
                }  
                
                r++;
            }
            
            while(l<=r && formed == charCountMapForT.size()){
                if(ans[0]==-1 || r-l < ans[2]-ans[1]+1){
                    ans[0] = r-l;
                    ans[1] = l;
                    ans[2] = r-1;                    
                }
                
                char toDelChar = s.charAt(l);
                
                if(charCountMapForT.containsKey(toDelChar)){
                    slidingWindow.put(toDelChar, slidingWindow.get(toDelChar)-1);
                    
                    if(slidingWindow.get(toDelChar) < charCountMapForT.get(toDelChar))
                        formed--;                    
                }
                
                l++;
            }
        }
        
        //return substring
        if(ans[0]==-1)
            return "";
        else
            return s.substring(ans[1], ans[2]+1);
    }
}