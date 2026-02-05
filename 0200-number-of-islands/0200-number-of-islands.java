class Solution {
    static int [] dc = {-1,1,0,0};
    static int [] dr = {0,0,-1,1};
    static int col;
    static int row;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int components = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,visited,grid);
                    components++;
                }
            }
        }
        return components;
    }
    private void dfs(int r, int c, boolean[][] visited, char[][] grid){
        if(r<0 || c<0 || r>=row || c>= col || grid[r][c] == '0'){
            return;
        } 
        if(visited[r][c]) return;
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            dfs(r+dr[i], c+dc[i], visited, grid);
        }
    }
}