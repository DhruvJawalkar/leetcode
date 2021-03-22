class Solution {
    public int numIslands(char[][] grid) {
        //init visited[][], num islands
        int numIslands = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        //iterate over grid on each unvisited 1 do dfs
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i, j, grid, visited);
                    numIslands++;
                }
            }
        }
        
        //return numIslands
        return numIslands;
    }
    
    private static void dfs(int i, int j, char[][] grid, boolean[][] visited){
        if(i<0 || i==visited.length || j<0 || j==visited[0].length || grid[i][j]!='1' || visited[i][j]==true)
            return;
        
        visited[i][j] = true;
        
        dfs(i+1, j, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j+1, grid, visited);
        dfs(i, j-1, grid, visited);
    }
}