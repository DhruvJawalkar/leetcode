class Solution {
    public boolean wordPattern(String pattern, String str) {
         String[] words = str.split(" ");
        
         if(pattern.length() != words.length) return false;
        
        HashMap<Character, String> map = new HashMap<>();
         HashSet<String> set = new HashSet<>();
        
         for(int i=0; i<pattern.length(); i++){
             char ch = pattern.charAt(i);
             
             if(!map.containsKey(ch)){
                 if(set.contains(words[i])) 
                     return false;
                     
                 map.put(ch, words[i]);
                 set.add(words[i]);
             } 
             else{
                 if(!map.get(ch).equals(words[i])) 
                     return false;
             }
          }
        
          return true;
     }
}