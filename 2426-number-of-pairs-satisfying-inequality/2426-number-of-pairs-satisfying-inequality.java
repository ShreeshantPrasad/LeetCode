class Solution {
    static class SegTree{
        int n;
        int [] tree;
        public SegTree(int n){
            this.n = n;
            tree = new int[4*n];
        }
        public int query(int node, int L, int R, int ql, int qr){
            if(L > qr || R < ql){
                return 0;
            }
            if(ql <= L && R <= qr){
                return tree[node];
            }
            int mid = L + (R-L)/2;
            return query(2*node+1, L, mid, ql, qr) + query(2*node+2, mid+1, R, ql, qr);
        }
        public void update(int node, int L, int R, int idx){
            if(L==R){
                tree[node]++;
                return;
            }
            int mid = L + (R-L)/2;
            if(idx <= mid){
                update(2*node + 1, L, mid, idx);
            }
            else{
                update(2*node + 2, mid+1, R, idx);
            }
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }
    
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int [] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = nums1[i] - nums2[i];
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int val : ans){
            set.add(val);
            set.add(val+diff);
        }
        List<Integer> list = new ArrayList<>(set);

        int idx = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i),idx++);
            }
        }
        long count = 0;
        SegTree seg = new SegTree(idx);
        for(int j = 0; j < n; j++){
            int right = map.get(ans[j] + diff);
             count += seg.query(0, 0, idx-1, 0, right);
             seg.update(0, 0, idx-1, map.get(ans[j]));
        }
        return count;
    }
}