class Solution {
    int[] parent;
    int[] rank;
    int component;
    public int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        rank = new int[n];
        component = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j = i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i,j);
                }
            }
        }
        return n-component;
    }
    public void union(int a, int b) {
       
        int p_x = find(a);
        int p_y = find(b);
        if(p_x == p_y) return;
        if(rank[p_x] > rank[p_y]){
            parent[p_y] = p_x;
        }
        else if(rank[p_x] < rank[p_y]){
            parent[p_x] = p_y;
        }
        else{
            parent[p_x] = p_y;
            rank[p_y]++;
        }
        component--;
    }
}