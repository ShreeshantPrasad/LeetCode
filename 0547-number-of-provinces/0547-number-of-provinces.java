class Solution {
    int[] parent;
    int [] rank;
    public int find(int x, int[] parent){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x],parent);
    }
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        rank = new int[isConnected.length];
        int [][] edges = new int[isConnected.length][2];
        for(int i = 0; i < isConnected.length; i++){
           for(int j = 0; j < isConnected.length; j++){
                if(isConnected[i][j] == 1 && isConnected[j][i] == 1){
                    edges[i][0] = i;
                    edges[i][1] = j;
                }
            }
        }
        for(int i = 0; i < isConnected.length; i++){
            parent[i] = i;
        }
        Arrays.fill(rank,0);
        int comp = isConnected.length;
        for(int k = 0; k < isConnected.length; k++){
            int p_x = find(edges[k][0],parent);
            int p_y = find(edges[k][1],parent);
            if(p_x == p_y) return comp;
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
        return comp;
    }    
}