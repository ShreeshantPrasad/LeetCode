class Solution {
    int M,N;
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        M = m;
        N = n;
        dp = new Integer[m+1][n+1];
        return help(0,0);

    }
    private int help(int i, int j){
        if(i == M-1 && j == N-1) return 1;
        if(i < 0 || i >= M || j < 0 || j >= N) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int right = help(i,j+1);
        int down = help(i+1,j);

        return dp[i][j] = right+down;
    }

}