class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        
        int maxx=1;
        int lastIdx = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int curr=0; curr<dp.length; curr++){
            for(int prev=0; prev<curr; prev++){
                if(nums[curr] % nums[prev] == 0 && dp[prev]+1 > dp[curr]){
                    dp[curr] = 1+dp[prev];
                    maxx = Math.max(maxx,dp[curr]);
                    parent[curr] = prev;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(dp[i]==maxx){
                lastIdx=i;
                break;
            }
        }
        for(int i=lastIdx; i!=-1; i=parent[i]){
            list.add(nums[i]);
        }
        Collections.reverse(list);
        return list;
    }
}