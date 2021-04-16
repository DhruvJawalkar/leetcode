class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length;
        int[] refund = new int[n];
        int minCost = 0;
        
        for(int i=0; i<costs.length; i++){
            refund[i] = costs[i][1] - costs[i][0];
            minCost += costs[i][0];
        }
        
        Arrays.sort(refund);
        
        for(int i=0; i<n/2; i++){
            minCost += refund[i];
        }
        
        return minCost;
    }
}