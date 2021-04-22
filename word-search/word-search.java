class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() > board.length*board[0].length)
            return false;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board, i, j, word, 0))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    
    private boolean dfs(char[][] board, int i, int j, String word, int idx){
        if(idx==word.length())
            return true;
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || word.charAt(idx)!=board[i][j])
            return false;
        
        char ch = board[i][j];
        board[i][j] = '*';
        boolean found = false;
        
        for(int[] dir : dirs){
            if(dfs(board, i+dir[0], j+dir[1], word, idx+1)){
                found = true;
                break;   
            } 
        }
        
        board[i][j] = ch;
        
        return found;
    }
}