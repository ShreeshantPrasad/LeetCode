class Solution {
    public int find(int x, int[] parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x],parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length+1];
        int [] rank = new int[edges.length+1];
        int [] ans = new int[2];
        int comp = edges.length+1;
        for(int i = 0; i<edges.length+1; i++){
            parent[i] = i;
        }
        Arrays.fill(rank,0);
        for(int k = 0; k<edges.length; k++){
            int p_x = find(edges[k][0],parent);
            int p_y = find(edges[k][1],parent);
            if (p_x == p_y) {
                ans[0] = edges[k][0];
                ans[1] = edges[k][1];
            };
            if(rank[p_x] > rank[p_y]){
                parent[p_y] = p_x;
                comp--;
            }
            else if(rank[p_x] < rank[p_y]){
                parent[p_x] = p_y;
                comp--;
            }
            else{
                parent[p_x] = p_y;
                rank[p_y]++;
                comp--;
            }
        
        }
        return ans;

        
    }
}