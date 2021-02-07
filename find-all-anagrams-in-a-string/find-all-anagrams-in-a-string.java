class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s==null || s.length()==0 || s.length()<p.length()) return result;
        
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        int S = s.length();
        int P = p.length();
        
        for(int i=0; i<P; i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
        }
        
        if(pMap.equals(sMap)){
            result.add(0);
        }
        
        for(int i = 1; i<=S-P; i++){
            char prev = s.charAt(i-1);
            if(sMap.containsKey(prev)){
                if(sMap.get(prev)==1){
                    sMap.remove(prev);
                }
                else{
                    sMap.put(prev, sMap.get(prev)-1);
                }
            }
            
            char next = s.charAt(i+P-1);
            sMap.put(next, sMap.getOrDefault(next,0)+1);
            
            if(pMap.equals(sMap)){
                result.add(i);
            }
        }
        
        return result;
    }
}