class Solution {
    boolean [] vis;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        } 
        vis = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                cnt++;
                dfs(adj,i);
            }
        }  
        return cnt;
    }
    private void dfs(Map<Integer, List<Integer>> adj, int u){
        vis[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v]){
                dfs(adj,v);
            }
        }
    }
}