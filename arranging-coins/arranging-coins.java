class Solution {
    public int arrangeCoins(int n) {
        if(n==0)
            return 0;
        
        int numCoins = n, r = 0;
        
        while(n-(r+1)>=0){
            n = n-(r+1);
            r = r+1;
        }
        
        return r;
    }
}