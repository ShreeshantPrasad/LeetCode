class Solution {
    int [] dr = {1,-1,0,0};
    int [] dc = {0,0,1,-1};
    int n;
    int m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        boolean [][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(i,j,vis,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(int r, int c, boolean [][] vis, char [][] grid){
        if(r < 0 || c < 0 || r >= n || c >= m || vis[r][c] || grid[r][c] == '0'){
            return;
        }
        vis[r][c] = true;
        for(int i = 0; i < 4; i++){
            dfs(r+dr[i], c+dc[i], vis, grid);
        }
    }
}