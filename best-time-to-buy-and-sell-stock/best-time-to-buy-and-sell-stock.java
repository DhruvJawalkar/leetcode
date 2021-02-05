class Solution {
    public int maxProfit(int[] prices) {
        //base case
        if(prices==null || prices.length<=1)
            return 0;
        
        //initialize maxProfit, minSoFar
        int maxProfit=0, minSoFar = prices[0], maxSoFar = prices[0];
        
        //iterate over array, if curElem>minSoFar calculate profit, else update minSoFar
        for(int i=1; i<prices.length; i++){
            if(prices[i]>minSoFar)
                maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            else
                minSoFar = prices[i];
        }
        
        //return maxProfit
        return maxProfit;
    }
}