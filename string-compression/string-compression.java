/*
Ex:         ["a","b","1","2","b","b","b","b","b","b","b","b","b"]
                                                              i
curCount=12
                             idx

TC - O(n)
SC - O(log n)     
*/

class Solution {
    public int compress(char[] chars) {
        if(chars.length==1)
            return 1;
        
        char curCount = 1;
        int idx = 0;
        int n = chars.length;
        
        for(int i=0; i<n; i++){
            if(i==n-1 || chars[i]!=chars[i+1]){
                chars[idx++] = chars[i];
                
                if(curCount>1){
                    String countStr = Integer.toString(curCount);    
                    
                    for(char digit : countStr.toCharArray()){
                        chars[idx++] = digit;
                    }
                }
                
                curCount = 1;
            }
            else{
                curCount += 1;
            }
        }
        
        return idx;
    }
}