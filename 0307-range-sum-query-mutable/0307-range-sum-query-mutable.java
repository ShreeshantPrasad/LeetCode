class NumArray {
    static int[] segTree;
    static int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        buildTree(0, 0, n-1, nums);
    }
    
    public void update(int index, int val) {
        updateTree(index, val, 0, 0, n-1);
    }
    
    public int sumRange(int left, int right) {
        return query(left, right, 0, 0, n-1);
    }
    public void buildTree(int idx, int l, int r, int[]nums){
        if(l==r) {
            segTree[idx] = nums[l];
            return;
        } 
        int mid = (l+r)/2;
        buildTree((2*idx)+1, l, mid, nums);
        buildTree((2*idx)+2, mid+1, r, nums);
        segTree[idx] = segTree[(2*idx)+1] + segTree[(2*idx)+2];
    }

    public void updateTree(int idx, int val, int i, int l, int r){
        if(l==r) {
            segTree[i] = val;
            return;
        }

        int mid = l+(r-l)/2;
        if(idx<=mid){
            updateTree(idx, val, 2*i+1, l, mid);
        }else {
            updateTree(idx, val, 2*i+2, mid+1, r);
        }

        segTree[i] = segTree[(2*i)+1] + segTree[(2*i)+2];
    }

    public int query(int left, int right, int idx, int l, int r){
        if(l>right || r<left){
            return 0;
        }

        if(l>=left && r<=right){
            return segTree[idx];
        }

        int mid = l+(r-l)/2;
        return query(left, right, (2*idx)+1, l, mid) + query(left, right, (2*idx)+2, mid+1, r);

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */