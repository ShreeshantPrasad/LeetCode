class Solution {
    int [] dp = new int[1001];
    int MOD = 1_000_000_007;
    public int numTilings(int n) {
        Arrays.fill(dp,-1);
        return solve(n);
    }
    private int solve(int n){
        if(n == 1 || n == 2){
            return n;
        }
        if(n == 3) return 5;
        if(dp[n] != -1) return dp[n];
        return dp[n] = ((2*solve(n-1)) % MOD + (solve(n-3)) % MOD) % MOD;
    }
}