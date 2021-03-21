/*
TC - O(n)
SC - O(n)

Input: s = "egg", t = "add"
{
e: a
g: d
}

{
a: e
d: g
}
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        //init 2 hashmaps
        HashMap<Character, Character> mapping = new HashMap<>();
        HashMap<Character, Character> revMapping = new HashMap<>();
        
        //iterate over a string 
            //check in rev mapping if mapping already exists
            //else check if char exists in mapping and maps to same char
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if(revMapping.containsKey(b) && revMapping.get(b)!=a)
                return false;
            
            if(mapping.containsKey(a) && mapping.get(a)!=b)
                return false;
            
            if(!mapping.containsKey(a)){
                mapping.put(a, b);
                revMapping.put(b, a);
            }
        }
        
        //return true if reaches the end
        return true;
    }
}