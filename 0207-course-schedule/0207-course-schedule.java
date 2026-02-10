class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] deg = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++){
            deg[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(deg[i]==0){
                q.offer(i);
            }
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        
        for(int[] e:prerequisites){
            int u = e[0];
            int v = e[1];
            
            adj.get(v).add(u);
            
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int n:adj.get(node)){
                deg[n]--;
                if(deg[n]==0) q.offer(n);
            }
        }
        return res.size()==numCourses;
    }
}