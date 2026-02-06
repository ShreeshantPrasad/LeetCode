class Solution {
    static int rowL,colL;
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    int maxTime = 0;

    public int orangesRotting(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        // var vis = new boolean[rowL][colL];
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        //add all rotten oranges into queue
        for(int i = 0; i<rowL; i++){
            for(int j = 0;j<colL; j++){
                if(grid[i][j] == 2){ //rotten
                    q.offer(new int[] {i,j,0});   //row,col,time
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int T = curr[2];

            maxTime = Math.max(maxTime,T);

            // if(fresh==0) continue;
            for(int i = 0; i < 4;  i++){
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                //check valid and add to queue
                if(nRow >= 0 && nCol >= 0 && nRow<rowL && nCol<colL && grid[nRow][nCol] == 1){
                    grid[nRow][nCol] = 2;
                    fresh--;
                    q.offer(new int[] {nRow,nCol,T+1});
                }
            }
        }
        return fresh==0 ? maxTime : -1;
    }
}