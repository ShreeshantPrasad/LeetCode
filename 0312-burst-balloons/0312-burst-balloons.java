class Solution {
    static int solve(int i, int j, ArrayList<Integer> a) {
        if (i > j) return 0;
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1)
                       + solve(i, ind - 1, a) + solve(ind + 1, j, a);
            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : nums){
            arr.add(i);
        }
        arr.add(1);
        arr.add(0,1);
        return solve(1, n, arr);
    }
}