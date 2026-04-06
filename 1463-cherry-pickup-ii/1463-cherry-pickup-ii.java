class Solution {
    int n;
    public int cherryPickup(int[][] grid) {
        n = grid[0].length;
        Integer [][][] dp = new Integer[71][71][71];
        return helper(grid,0,0,n-1,dp);
    }
    private int helper(int[][] grid, int r, int c1, int c2, Integer [][][] dp){
        if (r >= grid.length) return 0;
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];
        int cherry = grid[r][c1];
        if(c1 != c2){
            cherry += grid[r][c2];
        }

        int ans = 0;

        for(int i = -1; i <=1; i++){
            for(int j = -1; j <= 1; j++){
                int newR = r+1;
                int newC1 = c1 + i;
                int newC2 = c2 + j;
                if(newC1 >= 0 && newC1 < n && newC2 >= 0 && newC2 < n){
                    ans = Math.max(ans, helper(grid,newR,newC1,newC2,dp));
                }
            }
        }
        return dp[r][c1][c2] = cherry + ans;
    }
}