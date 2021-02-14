class Solution {
    public int maximumWealth(int[][] accounts) {
        if(accounts==null || accounts.length==0 || accounts[0].length==0)
            return 0;
        
        int maxWealth = 0;
        
        for(int i=0; i<accounts.length; i++){
            int curWealth = 0;
            for(int j=0; j<accounts[i].length; j++){
                curWealth += accounts[i][j];
            }
            
            maxWealth = Math.max(maxWealth, curWealth);
        }
        
        return maxWealth;
     }
}