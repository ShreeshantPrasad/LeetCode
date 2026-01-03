class Solution {
        public int MOD = (int)(1e9) + 7;
        int pattern[][]= {
        {1,2,1}, {1,3,1},
        {2,1,2}, {2,3,2},
        {3,1,3}, {3,2,3},
        {1,2,3}, {1,3,2},
        {2,1,3}, {2,3,1},
        {3,2,1}, {3,1,2}
    };
    public int numOfWays(int n) {
        int dp[][] = new int[n][13];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
            
        }
        return solve(12,0, n, dp);
    }
    public int solve(int patternIdx,  int r, int n,int dp[][]){
        if(r == n) return 1;
        if(dp[r][patternIdx] != -1) return dp[r][patternIdx];
        long ans = 0;
        for(int i=0;i<12; i++){
            if(patternIdx != 12 && (pattern[i][0] == pattern[patternIdx][0] ||
            pattern[i][1] == pattern[patternIdx][1] ||
            pattern[i][2] == pattern[patternIdx][2] ) ){
                continue;
            }
            ans += solve(i, r+1, n, dp);
            ans %=MOD;
        }
        return dp[r][patternIdx] = (int)ans;
    }
}