class Solution {
    Integer [][] dp;
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        dp = new Integer[s.length()+1][sb.length()+1];
        return solve(0,0,s,sb.toString());
    }
    private int solve(int i, int j, String s1, String s2){
        if(i >= s1.length() || j >= s2.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + solve(i+1,j+1,s1,s2);
        }else{
            ans = Math.max(solve(i+1,j,s1,s2), solve(i,j+1,s1,s2));
        }
        return dp[i][j] = ans;
    }
}