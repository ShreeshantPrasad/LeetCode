class Solution {
    int [] dp = new int[1001];
    int MOD = 1_000_000_007;
    public int numTilings(int n) {
        // if(n == 1 || n == 2){
        //     return n;
        // }
        // if(n == 3) return 5;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i = 4; i <= n; i++){
            dp[i] = ((2*dp[i-1]) % MOD + (dp[i-3]) % MOD) % MOD;
        }
        return dp[n];
    }
}