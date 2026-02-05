class Solution {
    static int [] dc = {-1,1,0,0};
    static int [] dr = {0,0,-1,1};
    static int colL;
    static int rowL;
    public int maxAreaOfIsland(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        boolean[][] visited = new boolean[rowL][colL];
        int island = 0;
        for(int i=0; i<rowL; i++){
            for(int j=0; j<colL; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int[] size = {0};
                    dfs(i,j,visited,grid,size);
                    island = Math.max(island,size[0]);
                }
            }
        }
        return island;
    }
    private void dfs(int r, int c, boolean[][] visited, int[][] grid,int[] size){
        if(r<0 || c<0 || r>=rowL || c>= colL || grid[r][c] == 0){
            return;
        } 
        if(visited[r][c]) return;
        size[0]++;
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i], c+dc[i], visited, grid,size);
        }
    }
}