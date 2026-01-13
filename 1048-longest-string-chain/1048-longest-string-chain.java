class Solution {
    public boolean checkPossible(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;
        int f = 0;
        int s = 0;
        while(f < s1.length()){
            if (s < s2.length() && s1.charAt(f) == s2.charAt(s)){
                f++;
                s++;
            }else{
                f++;
            }
        }
        return (f == s1.length() && s == s2.length()) ? true : false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n=words.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(checkPossible(words[i],words[j]) && dp[j]+1 > dp[i]){
                    dp[i]=1+dp[j];
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}