class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int ans = 0;
        int cnt = 1;
        for(int i = n-1; i >= 0; i--){
            if(cnt % 3 == 0){
                cnt++;
            }
            else{
                ans += cost[i];
                cnt++;
            }
        }
        return ans;
    }
}