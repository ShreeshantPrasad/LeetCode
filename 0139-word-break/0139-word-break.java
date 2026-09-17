class Solution {
    private Boolean[] dp;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dp = new Boolean[s.length()];
        return solve(s, 0, wordDict);
    }
    
    private boolean solve(String s, int idx, List<String> wordDict) {
        if (idx == n) {
            return true;
        }
        if (dp[idx] != null) return dp[idx];
        
        for (int endIdx = idx + 1; endIdx <= n; endIdx++) {
            String split = s.substring(idx, endIdx);
            if (wordDict.contains(split) && solve(s, endIdx, wordDict)) {
                return dp[idx] = true;
            }
        }
        
        return dp[idx] = false;
    }
}