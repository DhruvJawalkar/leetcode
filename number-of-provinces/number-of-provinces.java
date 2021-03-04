class Solution {
    public int findCircleNum(int[][] isConnected) {
        //base cases
        if(isConnected==null || isConnected.length==0 || isConnected[0].length==0)
            return 0;
        
        //init adjacency list, visited[], numProvinces
        int n = isConnected.length;
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();
        boolean[] visited = new boolean[n];
        int numProvinces = 0;
        
        for(int i=0; i<isConnected.length; i++){
            adjacencyList.put(i, new HashSet<>());    
        }
        
        for(int i=0; i<isConnected.length; i++){    
            for(int j=i+1; j<isConnected[0].length; j++){
                if(isConnected[i][j]==1){
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }
        
        //for each unvisited node call dfs, increment numProvinces
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, adjacencyList, visited);
                numProvinces++;
            }
        }
        
        //return numProvinces
        return numProvinces;
    }
    
    //dfs, if visited return, iterate over unvisited neighbours from adjacency list, mark visited, do dfs 
    private void dfs(int n, HashMap<Integer, HashSet<Integer>> adjacencyList, boolean[] visited){
        for(int neighbour : adjacencyList.get(n)){
            if(!visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour, adjacencyList, visited);
            }
        }   
    }
}