class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        int v = rooms.size();
        boolean [] vis = new boolean[v];
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode : rooms.get(node)){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
        for(boolean i : vis){
            if(i == false) return false;
        }
        return true;
    }
    
}