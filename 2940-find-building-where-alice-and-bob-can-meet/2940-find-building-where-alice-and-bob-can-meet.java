class Solution {
    int[] segTree;

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;

        segTree = new int[4 * n];
        buildTree(heights, 0, 0, n - 1);

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int alice = queries[i][0];
            int bob = queries[i][1];

            if (alice > bob) {
                int temp = alice;
                alice = bob;
                bob = temp;
            }

            if (alice == bob) {
                ans[i] = alice;
                continue;
            }

            if (heights[alice] < heights[bob]) {
                ans[i] = bob;
                continue;
            }

            int target = Math.max(heights[alice], heights[bob]);

            ans[i] = queryTree(0, 0, n - 1, bob + 1, target);
        }
        return ans;
    }

    public int queryTree(int node, int left, int right, int queryStart, int target) {
        if (right < queryStart || segTree[node] <= target) return -1;

        if (left == right) return left;

        int mid = left + (right - left) / 2;
        int leftChild = node * 2 + 1;
        int rightChild = node * 2 + 2;

        int ans = -1;

        if (segTree[leftChild] > target)
            ans = queryTree(leftChild, left, mid, queryStart, target);

        if (ans != -1) return ans;

        return queryTree(rightChild, mid + 1, right, queryStart, target);
    }

    public void buildTree(int[] arr, int node, int left, int right) {
        if (left == right) {
            segTree[node] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;
        int leftChild = node * 2 + 1;
        int rightChild = node * 2 + 2;

        buildTree(arr, leftChild, left, mid);
        buildTree(arr, rightChild, mid + 1, right);

        segTree[node] = Math.max(segTree[leftChild], segTree[rightChild]);
    }
}