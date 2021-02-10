class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //TC - O(N * W log W), W-avg word length
        //SC - O(N * W)
        
        //base case
        if(strs==null || strs.length==0)
            return new ArrayList<List<String>>();
        
        //initialize hashmap
        HashMap<String, List<String>> map = new HashMap<>();
        
        //for each string, sort chars in string and put in hashmap entry
        for(String word : strs){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            
            String sortedKey = new String(arr);
            System.out.println(sortedKey);
            if(!map.containsKey(sortedKey))
                map.put(sortedKey, new ArrayList<String>());
            
            map.get(sortedKey).add(word);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        //in the end return all entires in a list
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        
        return result;
    }
}