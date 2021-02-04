class Solution {
    public boolean exist(char[][] board, String word) {
        //base case
        if(board==null || board.length==0 || board[0].length==0 || word.length()==0)
            return false;
        
        //iterate over board check for first char match
            //call backtrack fn to go till end of word, return true/false
            //if we get true return true else continue
        int m = board.length;
        int n = board[0].length;
        int idx = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(idx)){
                    char temp = board[i][j];
                    board[i][j] = 'X';
                    
                    boolean found = helper(i, j, board, word, idx+1);
                
                    board[i][j] = temp;
                    
                    if(found)
                        return true;
                }        
            }
        }
        
        //default return value is false        
        return false;
    }
    
    //initialize dirs[][] 
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    //backtrack fn, row, col, pass board, word, cur idx being matched, explore all 4 dirs, proceed if word[idx] is a match
    //to avoid coming back to same pos set board[i][j] to X
    //on backtrack reset
    //check if idx reaches word.length then return true else return false
    private boolean helper(int row, int col, char[][] board, String word, int idx){
        //base case
        if(idx==word.length())
            return true;
        
        for(int[] dir : dirs){
            int i = dir[0]+row;
            int j = dir[1]+col;
            
            if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]==word.charAt(idx)){
                char temp = board[i][j];
                board[i][j] = 'X';
                
                boolean found = helper(i, j, board, word, idx+1);
                
                board[i][j] = temp;
                
                if(found)
                    return true;
            }
        }
        
        return false;
    }
}