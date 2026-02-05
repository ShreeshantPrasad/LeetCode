class Solution {
    static int rowL;
    static int colL;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    public int closedIsland(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        var visited = new boolean[rowL][colL];
        for(int i=0; i<rowL; i++){
            for(int j=0; j<colL; j++){
                if((i == 0 || j == 0 || i == rowL-1 || j == colL-1) && grid[i][j] == 0){
                    dfs(i,j,grid,visited);
                }
            }
        }
        int islands = 0;
        for(int i = 0; i<rowL; i++){
            for(int j = 0; j<colL; j++){
                if(!visited[i][j] && grid[i][j] == 0){
                    dfs(i,j,grid,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(int r, int c, int [][] grid, boolean[][] visited){
        if(r<0 || c<0 || r >= rowL || c >= colL || grid[r][c] != 0) return;
        if(visited[r][c]) return;
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            dfs(r + dr[i], c + dc[i], grid, visited);
        }
    }
}