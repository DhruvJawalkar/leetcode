class Solution {
    public int minInsertions(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        int n = s.length();
        int[][] memo = new int[n][n];
        int i=0, j=s.length()-1;
        return helper(s, i, j, memo);    
    }
    
    private static int helper(String s, int i, int j, int[][] memo){
        if(i>=j)
            return 0;
        
        if(memo[i][j]!=0)
            return memo[i][j];
        
        if(s.charAt(i)==s.charAt(j))
            memo[i][j] = helper(s, i+1, j-1, memo);
        else
            memo[i][j] = 1+Math.min(helper(s, i+1, j, memo), helper(s, i, j-1, memo));  
        
        return memo[i][j];          
    }
}