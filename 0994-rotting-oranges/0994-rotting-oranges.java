class Solution {
    int rl, cl;
    int [] dr = {0, 0, -1, 1};
    int [] dc = {-1, 1, 0, 0};
    public int orangesRotting(int[][] grid) {
        rl = grid.length;
        cl = grid[0].length;
        int fresh = 0;
        int maxT = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rl; i++){
            for(int j = 0; j < cl; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            maxT = Math.max(maxT, t);
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < rl && nc >= 0 && nc < cl && grid[nr][nc] == 1){
                    fresh--;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr,nc,t+1});
                }
            }
        }
        return fresh == 0 ? maxT : -1;
    }
}