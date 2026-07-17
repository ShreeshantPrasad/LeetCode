class Solution {
    class Pair{
        String ch;
        double val;
        Pair(String ch, double val){
            this.ch = ch;
            this.val = val;
        } 
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair>> adj = new HashMap<>();
        int n = equations.size();
        for(int i = 0; i < n; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, val));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 1.0/val));
        }
        double [] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            double [] ans = {-1.0};
            if(adj.containsKey(start)){
                Set<String> vis = new HashSet<>();
                dfs(adj,start,end,vis,1.0,ans);
            }
            res[i] = ans[0];
        }
        return res;
    }
    private void dfs(Map<String,List<Pair>> adj, String strt, String end, Set<String> vis, double prod, double[] ans){

        if(vis.contains(strt)) return;
        vis.add(strt);
        if(strt.equals(end)){
            ans[0] = prod;
            return;
        }
        for(Pair p : adj.getOrDefault(strt, new ArrayList<>())){
            dfs(adj, p.ch, end, vis, prod*p.val, ans);
        }
    }
}