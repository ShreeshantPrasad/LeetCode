class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int n = row * col;

        k = k % n;
        if(k != 0){
            rev(grid, col, 0, n-1);
            rev(grid, col, 0, k-1);
            rev(grid, col, k, n-1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int [] r : grid){
            List<Integer> curr = new ArrayList<>();
            for(int val : r){
                curr.add(val);
            }
            ans.add(curr);
        }
        return ans;
    }
    public void rev(int[][] grid, int col, int i, int j){
        while(i < j){
            int temp = grid[i / col][i % col];
            grid[i / col][i % col] = grid[j / col][j % col];
            grid[j / col][j % col] = temp;
            i++;
            j--;
        }
    }
}