class Solution {
    public class Pair{
        int node;
        long dis;
        public Pair(int node, long dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int [] edge : roads){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        long [] dis = new long[n+1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;

        long [] ways = new long[n+1];
        Arrays.fill(ways, -1);
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Long.compare(a.dis,b.dis));
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            long dist = curr.dis;
            if(dist> dis[u]) continue;
            for(Pair adjNode : adj.get(u)){
                int v = adjNode.node;
                long cost = adjNode.dis;
                if(dis[v] > dis[u] + cost){
                    dis[v] = dis[u] + cost;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v,dis[v]));
                }
                else if(dis[v] == dis[u]+cost){
                    ways[v] = (ways[u]+ways[v]) % 1_000_000_007;
                }
            }
        }
        return (int) ways[n-1];

    }
}