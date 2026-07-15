class Solution {
    boolean [] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        vis = new boolean[rooms.size()];
        dfs(rooms, 0);
        for(boolean x : vis){
            if(x == false) return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, int i){
        vis[i] = true;
        for(int next : rooms.get(i)){
            if (!vis[next]) {
                dfs(rooms, next);
            }
        }
    }
}