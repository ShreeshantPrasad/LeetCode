class Solution {
    int ans;
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int [] road : roads){
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(new int[] {v,d});
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(new int[] {u,d});

        }
        boolean [] vis = new boolean[n+1];
        ans = Integer.MAX_VALUE;
        dfs(adj,1,vis);
        return ans; 
    }
    private void dfs(Map<Integer, List<int[]>> adj, int u, boolean [] vis){
        vis[u] = true;
        for(int [] edge : adj.getOrDefault(u, new ArrayList<>())){
            int v = edge[0];
            int d = edge[1];

            ans = Math.min(ans, d);
            if(!vis[v]){
                dfs(adj,v,vis);
            }
        }
    }
}