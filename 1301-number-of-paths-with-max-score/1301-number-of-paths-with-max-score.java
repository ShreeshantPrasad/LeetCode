class Solution {
    int n;
    int MOD = 1_000_000_007;
    Integer[][] tScore;
    Integer[][] tPaths;
    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        tScore = new Integer[n][n];
        tPaths = new Integer[n][n];
        int [] ans = solve(n-1,n-1,board);
        return ans;
    }
    private int[] solve(int i, int j, List<String> board){
        if(board.get(i).charAt(j) == 'E'){
            return new int[] {0,1};
        }
        if(board.get(i).charAt(j) == 'X'){
            return new int[] {0,0};
        }
        if(tScore[i][j] != null){
            return new int[]{tScore[i][j], tPaths[i][j]};
        }

        int upScore = 0, upPaths = 0;
        int leftScore = 0, leftPaths = 0;
        int diagScore = 0, diagPaths = 0;

        char ch = board.get(i).charAt(j);
        //up
        if(isValid(i-1,j,board)){
            int [] ans = solve(i-1,j,board);
            upScore = ans[0];
            upPaths = ans[1];
            if(upPaths > 0) upScore += getInt(ch);
        }
        //left
        if(isValid(i,j-1,board)){
            int [] ans = solve(i,j-1,board);
            leftScore = ans[0];
            leftPaths = ans[1];
            if(leftPaths > 0) leftScore += getInt(ch);
        }
        //diag
        if(isValid(i-1,j-1,board)){
            int [] ans = solve(i-1,j-1,board);
            diagScore = ans[0];
            diagPaths = ans[1];
            if(diagPaths > 0) diagScore += getInt(ch);
        }

        int bestScore, bestPaths;
        if(upScore == leftScore && leftScore == diagScore){
            bestScore = upScore;
            bestPaths = upPaths + leftPaths + diagPaths;
        }else if(upScore == leftScore){
            bestScore = upScore;
            bestPaths = upPaths + leftPaths;
            if(diagScore > bestScore || (diagScore == bestScore && diagPaths > bestPaths)){
                bestScore = diagScore;
                bestPaths = diagPaths;
            }
        }else if(leftScore == diagScore){
            bestScore = leftScore;
            bestPaths = leftPaths + diagPaths;
            if(upScore > bestScore || (upScore == bestScore && upPaths > bestPaths)){
                bestScore = upScore;
                bestPaths = upPaths;
            }
        }else{
            bestScore = upScore;
            bestPaths = upPaths;
            if(leftScore > bestScore || (leftScore == bestScore && leftPaths > bestPaths)){
                bestScore = leftScore;
                bestPaths = leftPaths;
            }
            if(diagScore > bestScore || (diagScore == bestScore && diagPaths > bestPaths)){
                bestScore = diagScore;
                bestPaths = diagPaths;
            }
        }
        tScore[i][j] = bestScore;
        tPaths[i][j] =  bestPaths % MOD;
        return new int[] {tScore[i][j], tPaths[i][j]};


    }

    boolean isValid(int i, int j, List<String> board){
        if(i >= 0 && i < n && j >= 0 && j < n && board.get(i).charAt(j) != 'X') return true;
        return false;
    }
    int getInt(char ch){
        return ch != 'S' ? ch - '0' : 0;
    }
}