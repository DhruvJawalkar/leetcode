class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        if(jewels==null || jewels.length()==0 || stones==null || stones.length()==0)
            return 0;
        
        int count=0;
        for(char stone : stones.toCharArray()){
            if(jewels.indexOf(stone)>-1)
                count++;
        }
        
        return count;
    }
}