class Solution {
    int cnt;
    public int minReorder(int n, int[][] connections) {
        cnt = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] conn : connections){
            adj.get(conn[0]).add(new int[]{conn[1], 1} ); //real
            adj.get(conn[1]).add(new int[]{conn[0], 0} ); //real
        }
        dfs(0,-1,adj);
        return cnt;
    }
    private void dfs(int u, int parent, List<List<int[]>> adj){
        for(int [] edge : adj.get(u)){
            int v = edge[0];
            int sign = edge[1];

            if(v != parent){
                if(sign == 1) cnt++;
                dfs(v,u,adj);
            }
        }
    }
}