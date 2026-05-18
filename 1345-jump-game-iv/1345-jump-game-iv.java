class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;

        Map<Integer,List<Integer>> map = new HashMap<>();
        boolean [] vis = new boolean[n];

        for(int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();

                int left = curr-1;
                int right = curr+1;
                if(curr == n-1) return steps;

                if(left >= 0 && vis[left] != true){
                    q.offer(left);
                    vis[left] = true;
                }
                if(right < n && vis[right] != true){
                    q.offer(right);
                    vis[right] = true;
                }
                if(map.containsKey(arr[curr])){
                    for(int idx : map.get(arr[curr])){
                        if(!vis[idx]){
                            q.offer(idx);
                            vis[idx] = true;
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            steps++;
        }
        return -1;
    }
}