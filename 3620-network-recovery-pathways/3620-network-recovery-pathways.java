class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int l = Integer.MAX_VALUE;
        int r = 0;

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(!online[u] || !online[v]) continue;

            adj.computeIfAbsent(u,x -> new ArrayList<>()).add(new int[]{v,w});
            l = Math.min(l, w);
            r = Math.max(r, w);

        }
        int ans = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(check(mid,n,k,adj)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    private boolean check(int mid, int n, long k, Map<Integer, List<int[]>> adj){
        long[] res = new long[n];
        Arrays.fill(res,Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        res[0] = 0;
        pq.offer(new long[] {0,0});

        while(!pq.isEmpty()){
            long[] top = pq.poll();
            long d = top[0];
            int node = (int) top[1];

            if(d > k) return false;
            if(node == n-1) return true;

            if(d > res[node]) continue;
            for(int[] vec : adj.getOrDefault(node, Collections.emptyList())){
                int adjNode = vec[0];
                int cost = vec[1];

                if(cost < mid) continue;
                if(d + cost < res[adjNode]){
                    res[adjNode] = d + cost;
                    pq.offer(new long[] {d+cost, adjNode});
                }
            }
        }
        return false;

    }
}