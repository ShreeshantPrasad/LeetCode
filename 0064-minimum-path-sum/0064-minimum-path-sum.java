class Solution {
    int m,n;
    Integer [][] dp;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m+1][n+1];
        return help(0,0,grid);
    }
    private int help(int i, int j, int[][] grid){
        if(dp[i][j] != null) return dp[i][j];
        if(i == m-1 && j == n-1) return dp[i][j] = grid[i][j];
        else if(i == m-1) return dp[i][j] =  grid[i][j] + help(i,j+1,grid);
        else if(j == n-1) return dp[i][j] = grid[i][j] + help(i+1,j,grid);
        else{
            return dp[i][j] = grid[i][j] + Math.min(help(i,j+1,grid), help(i+1,j,grid));
        }
    }
}