class Solution {
    public int findCenter(int[][] edges) {
        int V = edges.length;
        int [][] mat = new int[V+2][V+2];
        for (int i = 0; i < V; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            mat[a][b] = 1;
            mat[b][a] = 1;
        }

        for(int i = 0; i<=V; i++){
            int cnt = 0;
            for(int j = 0; j<=V; j++){
                if(mat[i][j] == 1) cnt++;
            }
            if(cnt==V-1){
                return i;
            }
        }
        return -1; 
    }
}