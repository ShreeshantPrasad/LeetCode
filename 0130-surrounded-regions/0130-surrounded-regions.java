class Solution {
    static int [] dr= {-1,1,0,0};
    static int [] dc= {0,0,1,-1};
    public void solve(char[][] board) {
        int rowL = board.length;
        int colL = board[0].length;
        boolean [][] vis = new boolean[rowL][colL];
        for (int i=0; i<rowL; i++) {
            for (int j= 0; j<colL; j++) {
                if ((i==0 || j==0 || i==rowL-1 || j==colL-1)&& board[i][j]=='O'){
                    dfs(i, j,board, vis);
                }
            }
        }
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int r, int c, char[][] board, boolean[][] vis){
        int rowl= board.length;
        int coll= board[0].length;
        if(r<0 || c<0 || r>=rowl|| c>=coll || board[r][c]=='X') return;
        if(vis[r][c]) return;
        vis[r][c]=true;
        for(int i= 0; i<4; i++){
            dfs(r+dr[i], c+dc[i], board,vis);
        }  
    }
}