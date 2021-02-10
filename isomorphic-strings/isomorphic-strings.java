class Solution {
    public boolean isIsomorphic(String s, String t) {
        //base cases
        if(s==null || t==null)
            return s.equals(t);
        
        if(s.length()!=t.length())
            return false;
        
        //initialize hashmap
        HashMap<Character, Character> aToB = new HashMap<>();
        HashMap<Character, Character> bToA = new HashMap<>();
        
        //iterate over strings
        //check if mapping exists, if yes then verify, else put
        int n = s.length();
        for(int i=0; i<n; i++){
            char chA = s.charAt(i);
            char chB = t.charAt(i);
            
            if(!aToB.containsKey(chA)){
                if(!bToA.containsKey(chB)){
                    aToB.put(chA, chB);
                    bToA.put(chB, chA);
                }
                else 
                    return false;
            }
            else if(aToB.get(chA)!=chB)
                return false;
        }
        

        
        //return true default
        return true;
    }
}