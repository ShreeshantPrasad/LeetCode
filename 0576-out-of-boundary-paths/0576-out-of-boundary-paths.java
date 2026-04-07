class Solution {
    int M;
    int N;
    int MOD = 1_000_000_007;
    Integer [][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        M = m;
        N = n;
        dp = new Integer[51][51][51];
        return helper(startRow,startColumn,maxMove);
    }
    private int helper(int i, int j, int moves){
        if(i < 0 || i >= M || j < 0 || j >= N) return 1;
        if(moves == 0) return 0;
        if(dp[i][j][moves] != null) return dp[i][j][moves];

        int ans = (((helper(i+1, j, moves - 1) % MOD +
                    helper(i-1, j, moves - 1) % MOD ) % MOD+
                    helper(i, j+1, moves - 1) % MOD ) % MOD+
                    helper(i, j-1, moves - 1) % MOD ) % MOD;
        
        return dp[i][j][moves] = (ans%MOD);


    }
} 