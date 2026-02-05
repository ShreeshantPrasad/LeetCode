class Solution {
    static int [] dc = {-1,1,0,0};
    static int [] dr = {0,0,-1,1};
    static int colL;
    static int rowL;
    public int islandPerimeter(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        boolean[][] visited = new boolean[rowL][colL];
        int island = 0;
        for(int i=0; i<rowL; i++){
            for(int j=0; j<colL; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    island = dfs(i,j,visited,grid); 
                    break;
                }
            }
        }
        return island;
    }
    private int dfs(int r, int c, boolean[][] visited, int[][] grid){
        if(r<0 || c<0 || r>=rowL || c>= colL || grid[r][c] == 0){
            return 1;
        } 
        if(visited[r][c]) return 0;
        visited[r][c] = true;
        int size = 0;
        for(int i=0;i<4;i++){
            size += dfs(r+dr[i], c+dc[i], visited, grid);
        }
        return size;
    }
}