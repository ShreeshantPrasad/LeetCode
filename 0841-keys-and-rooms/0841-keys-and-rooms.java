class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       
        int v = rooms.size();
        boolean [] vis = new boolean[v];
        dfs(0,vis,rooms);
        for(boolean i : vis){
            if(i == false) return false;
        }
        return true;
    }
    public void dfs(int src, boolean[] visited, List<List<Integer>> adj){
        visited[src] = true;
        for(int adjNode : adj.get(src)){
            if(visited[adjNode]) continue;
            dfs(adjNode, visited, adj);
        }
    }
    
}