class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int numIslands = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    numIslands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        
        return numIslands;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j]!='1' || visited[i][j]==true)
            return;
            
        visited[i][j] = true;
        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j-1, visited);
        dfs(grid, i, j+1, visited);
    }
}