class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int power = 0;
        int nopower = arr[0];
        int ans = arr[0];
        for(int i = 1; i < n; i++){
            int v1 = arr[i];
            int v2 = nopower + arr[i];
            int v3 = power + arr[i];
            int v4 = nopower;
            power = Math.max(v3, v4);
            nopower = Math.max(v1, v2);
            ans = Math.max(ans, Math.max(power, nopower));
        }
        return ans;
    }
}