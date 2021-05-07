/*
TC - O(N^2 * L)
SC - O(N^2)

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]

{
    "hit" : ["hot"]
    "hot" : ["dot","lot"]
    "dot" : ["hot","dog","lot"]
    "dog" : ["dot","log","cog"]
    "lot" : ["hot","dot","log"]
    "log" : ["dog","lot","cog"]
    "cog" : ["dog","log"]
}
endWord = "cog"
seen = {"hit","hot","dot"}
numWords = 5

"hit"->"hot"->"dot"->"dog"->"cog"
queue - ["log", "cog"]
*/
class Solution {
    private void populateMap(HashMap<String, List<String>> map, String word){
        
        for(int i=0; i<word.length(); i++){
            String hash = word.substring(0, i) + "*" + word.substring(i+1, word.length());
            
            if(!map.containsKey(hash))
                map.put(hash, new ArrayList<String>());
            
            map.get(hash).add(word);
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        populateMap(map, beginWord);
        
        boolean found = false;
        for(int i=0; i<wordList.size(); i++){
            if(endWord.equals(wordList.get(i))){
                found = true;
                break;
            }
        }
        
        if(!found)
            return 0;
        
        for(String word : wordList){
            populateMap(map, word);
        }
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        int numWords = 1;
        
        queue.add(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                String curWord = queue.poll();
                seen.add(curWord);
                
                for(int j=0; j<curWord.length(); j++){
                    String hash = curWord.substring(0, j) + "*" + curWord.substring(j+1, curWord.length());
                    
                    if(map.containsKey(hash)){
                        List<String> matchingResults = map.get(hash);
                        
                        for(String res : matchingResults){
                            if(res.equals(endWord))
                                return numWords + 1;
                            
                            if(!seen.contains(res))
                                queue.add(res);
                        }
                    }
                }
                                
            }
            
            numWords++;
        }
        
        return 0;
    }
}