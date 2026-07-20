class Solution {
    int [] dr = {0,0,-1,1};
    int [] dc = {1,-1,0,0};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int [] temp = q.poll();
                int i = temp[0];
                int j = temp[1];

                if((i != entrance[0] || j != entrance[1]) && (i == 0 || i == m-1 || j == 0 || j == n-1)){
                    return steps;
                }
                for(int k = 0; k < 4; k++){
                    int newi = i + dr[k];
                    int newj = j + dc[k];

                    if(newi >= 0 && newj >= 0 && newi < m && newj < n && maze[newi][newj] != '+'){
                        q.offer(new int[] {newi, newj});
                        maze[newi][newj] = '+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}