class Solution {
  public int numSquares(int n) {
      
    int dp[] = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
      
    //bottom case
    dp[0] = 0;

    // pre-calculate the square numbers.
    int squaresNum = (int) Math.sqrt(n) + 1;
    int squares[] = new int[squaresNum];
    for (int i = 1; i < squaresNum; ++i) {
      squares[i] = i * i;
    }

    for (int i = 1; i <= n; ++i) {
      for (int s = 1; s < squaresNum; ++s) {
        if (i < squares[s])
          break;
        dp[i] = Math.min(dp[i], dp[i - squares[s]] + 1);
      }
    }
    return dp[n];
  }
}