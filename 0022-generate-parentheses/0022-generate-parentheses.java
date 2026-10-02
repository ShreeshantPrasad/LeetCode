class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open=0;
        int close=0;
        helper(n,open,close,"",ans);
        return ans;
    }
    void helper(int n, int open, int close, String s, List<String> ans){
        if(open+close==2*n){
            ans.add(s);
            return;
        }
        if(open<n) helper(n,open+1,close,s+"(",ans);
        if(close<open) helper(n,open,close+1,s+")",ans);
    }
}